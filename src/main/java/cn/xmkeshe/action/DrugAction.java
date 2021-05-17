package cn.xmkeshe.action;

        import cn.xmkeshe.service.IDrugService;
        import cn.xmkeshe.util.validate.ValidateUtils;
        import cn.xmkeshe.vo.Drug;
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
        import java.sql.Timestamp;
        import java.util.Date;
        import java.util.Map;

@Controller
@RequestMapping("/pages/admin/drug/DrugAction/*")
public class DrugAction {

    @RequestMapping("update")
    @RequiresUser
    @RequiresRoles("xmkeshe")
    public void update(String drid, HttpServletResponse response, HttpServletRequest request) {
        // 接收参数
        if (ValidateUtils.validateEmpty(drid) ) {
            try {
                if (this.drugService.update(drid)) {
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
                e.printStackTrace();
            }
        }
    }
    @Resource
    private IDrugService drugService;
    @RequestMapping("listSplit")
    @RequiresUser
    @RequiresRoles("xmkeshe")
    @RequiresPermissions("drug:list")
    public void listSplit(HttpServletResponse response, HttpServletRequest request) throws Exception {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        int currentPage = 1;
        int lineSize = 10;
        String keyWord = "";
        String column = "title";
        try {
            currentPage = Integer.parseInt(request.getParameter("page"));
        }catch (Exception e){}
        try {
            lineSize = Integer.parseInt(request.getParameter("limit"));
        }catch (Exception e){}
        keyWord = request.getParameter("kw");
        if(keyWord == null){
            keyWord = "";
        }
        Map<String, Object> map = this.drugService.listSplit(column,keyWord,currentPage, lineSize);
        map.put("msg", "''");
        map.put("code", 0);
        map.put("data", map.get("data"));
        map.put("count", map.get("count"));
        response.getWriter().print(JSONObject.toJSONString(map));
    }
    @RequestMapping("add")
    @RequiresUser
    @RequiresRoles("xmkeshe")
    @RequiresPermissions("drug:add")
    public void add(Drug vo, HttpServletResponse response, HttpServletRequest request) {
        String count = vo.getCount() + "";
        // 接收参数
        if (ValidateUtils.validateEmpty(vo.getDrid()) && ValidateUtils.validateEmpty(vo.getTitle())
                && ValidateUtils.validateEmpty(vo.getAddress()) && ValidateUtils.validateEmpty(vo.getPhone())
                && ValidateUtils.validateNumber(count)) {
            try {
                Item item = new Item();
                item.setIid(Integer.parseInt(request.getParameter("item")));
                vo.setIid(item);
                vo.setStatus(0); // 默认上架
                vo.setProdate(new Timestamp(new Date().getTime()));
                if (this.drugService.insert(vo)) {
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
                e.printStackTrace();
            }
        }
    }
}
