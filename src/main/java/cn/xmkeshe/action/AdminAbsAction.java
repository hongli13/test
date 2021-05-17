package cn.xmkeshe.action;

import cn.xmkeshe.service.IAdminService;
import cn.xmkeshe.util.md5.MD5Code;
import cn.xmkeshe.vo.Admin;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/pages/admin/AdminAbsAction/*")
public class AdminAbsAction {
    @Resource
    private IAdminService adminService;
    @RequestMapping("updateByPassword")
    public void updateByPassword(String aid,String password,HttpServletResponse response){
        try {
            if(this.adminService.updateByPassword(aid, new MD5Code().getMD5ofStr(password))){
                response.getWriter().print("success");
            }else{
                response.getWriter().print("error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("listSplit")
    @RequiresUser
    @RequiresRoles("admin")
    @RequiresPermissions("admin:list")
    public void listSplit(HttpServletResponse response, HttpServletRequest request) throws Exception {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        int currentPage = 1;
        int lineSize = 10;
        try {
            currentPage = Integer.parseInt(request.getParameter("page"));
        } catch (Exception e) {
        }
        try {
            lineSize = Integer.parseInt(request.getParameter("limit"));
        } catch (Exception e) {
        }
        Map<String, Object> map = this.adminService.listSplit(currentPage, lineSize);
        map.put("msg", "''");
        map.put("code", 0);
        map.put("data", map.get("data"));
        map.put("count", map.get("count"));
        response.getWriter().print(JSONObject.toJSONString(map));
    }
    @RequestMapping("add")
    @RequiresRoles("admin")
    @RequiresPermissions("admin:add")
    public void add(Admin vo,HttpServletRequest request,HttpServletResponse response){
        Set<Integer> all = new HashSet<Integer>();
        String result[] = request.getParameterValues("rid");
        for(int x = 0;x < result.length;x++){
            all.add(Integer.parseInt(result[x]));
        }
        vo.setPassword(new MD5Code().getMD5ofStr(vo.getPassword()));
        try {
            if(this.adminService.insert(vo,all)){
                response.getWriter().print("success");
            }else{
                response.getWriter().print("error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
