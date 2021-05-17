package cn.xmkeshe.realm;

import cn.xmkeshe.service.IAdminService;
import cn.xmkeshe.vo.Admin;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

@Component
public class AdminRealm extends AuthorizingRealm {
    private Logger log = Logger.getLogger(String.valueOf(AdminRealm.class));
    @Resource
    private IAdminService adminService;
    HttpServletResponse response;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("========登录授权认证========");
        // 1、取得用户名
        String username = (String) authenticationToken.getPrincipal();
        try {
            Admin vo = this.adminService.show(username);
            if (vo == null) {
                throw new UnknownAccountException("用户不存在！");
            } else {
                // 2、取得登录密码
                String password = (new String((char[]) authenticationToken.getCredentials()));
                if (vo.getPassword().equals(password)) {
                    AuthenticationInfo auth = new SimpleAuthenticationInfo(username, password, "adminRealm");
                    return auth;
                } else {
                    throw new IncorrectCredentialsException("密码错误！");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("========角色授权认证========");
        // 1、取得用户名
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo auth = new SimpleAuthorizationInfo();
        Map<String, Object> map = null;
        try {
            map = this.adminService.listAuthByAdmin(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        auth.setRoles((Set<String>) map.get("allRoles"));
        auth.setStringPermissions((Set<String>) map.get("allActions"));
        return auth;
    }
}
