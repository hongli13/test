package cn.xmkeshe.action;

import cn.xmkeshe.service.IAdminService;
import cn.xmkeshe.util.md5.MD5Code;
import cn.xmkeshe.util.validate.ValidateUtils;
import cn.xmkeshe.vo.Admin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/AdminAction/*")
public class AdminAction {

    @RequestMapping("logout")
    public void logout(HttpServletRequest request,HttpServletResponse response){
        try {
            request.getSession().invalidate(); // 让session失效
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("login")
    public void login(Admin vo, HttpServletResponse response,HttpServletRequest request) throws IOException {
        // 数据验证
        if (ValidateUtils.validateEmpty(vo.getAid()) && ValidateUtils.validateEmpty(vo.getPassword())) {
            String aid = vo.getAid(); // aid
            String password = new MD5Code().getMD5ofStr(vo.getPassword());
            UsernamePasswordToken token = new UsernamePasswordToken(aid, password);
            Subject sub = SecurityUtils.getSubject();
            try {
                sub.login(token);
                request.getSession().setAttribute("aid",aid);
                response.getWriter().print("success");
            }catch (Exception e){
                response.getWriter().print("error");
            }
        } else {
            response.getWriter().print("errorNull");
        }
    }
}
