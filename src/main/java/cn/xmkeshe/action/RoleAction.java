package cn.xmkeshe.action;

import cn.xmkeshe.service.IAdminService;
import cn.xmkeshe.service.IRoleService;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/pages/role/RoleAction/*")
public class RoleAction {
    @Resource
    private IRoleService roleService;
    @RequestMapping("list")
    @RequiresUser
    @RequiresRoles("admin")
    @RequiresPermissions("admin:add")
    public void list(HttpServletResponse response, HttpServletRequest request){
        response.setCharacterEncoding("UTF-8");
        try {
            request.setCharacterEncoding("UTF-8");
            response.getWriter().print(JSONObject.toJSONString(this.roleService.list()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
