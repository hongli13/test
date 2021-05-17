package cn.xmkeshe.action;

import cn.xmkeshe.service.IItemService;
import cn.xmkeshe.util.validate.ValidateUtils;
import cn.xmkeshe.vo.Item;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/pages/admin/item/ItemAction/*")
public class ItemAction {

    @Resource
    private IItemService itemService;

    @RequestMapping("list")
    @RequiresUser
    @RequiresRoles("xmkeshe")
    @RequiresPermissions("item:list")
    public void list(HttpServletResponse response, HttpServletRequest request){
        try {
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            response.getWriter().print(JSONObject.toJSONString(this.itemService.list()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("add")
    @RequiresUser
    @RequiresRoles("xmkeshe")
    @RequiresPermissions("item:add")
    public void add(Item vo, HttpServletResponse response) {
        // 数据验证
        if (ValidateUtils.validateEmpty(vo.getTitle()) && ValidateUtils.validateEmpty(vo.getNote())) {
            try {
                if (this.itemService.add(vo)) {
                    response.getWriter().print("success");
                } else {
                    response.getWriter().print("error");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                response.getWriter().print("error");
            } catch (IOException e) {
            }
        }
    }

    @RequestMapping("listSplit")
    @RequiresUser
    @RequiresRoles("xmkeshe")
    @RequiresPermissions("item:list")
    public void listSplit(HttpServletResponse response, HttpServletRequest request) throws Exception {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        int currentPage = 1;
        int lineSize = 10;
        try {
            currentPage = Integer.parseInt(request.getParameter("page"));
        }catch (Exception e){}
        try {
        lineSize = Integer.parseInt(request.getParameter("limit"));
        }catch (Exception e){}
        Map<String, Object> map = this.itemService.listSplit(currentPage, lineSize);
        map.put("msg", "''");
        map.put("code", 0);
        map.put("data", map.get("data"));
        map.put("count", map.get("count"));
        response.getWriter().print(JSONObject.toJSONString(map));
    }
}
