package cn.xmkeshe.action;

import cn.xmkeshe.service.IStockService;
import cn.xmkeshe.util.validate.ValidateUtils;
import cn.xmkeshe.vo.Stock;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@Controller
/// pages/admin/stock/StockAction/add.html
@RequestMapping("/pages/admin/stock/StockAction/*")
public class StockAction {
    @Resource
    private IStockService strockService;

    @RequestMapping("listSplit")
    @RequiresUser
    @RequiresRoles("xmkeshe")
    @RequiresPermissions("stock:list")
    public void listSplit(HttpServletResponse response, HttpServletRequest request, String title) throws Exception {
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
        Map<String, Object> map = this.strockService.listSplit(title, currentPage, lineSize);
        map.put("msg", "''");
        map.put("code", 0);
        map.put("data", map.get("data"));
        map.put("count", map.get("count"));
        response.getWriter().print(JSONObject.toJSONString(map, SerializerFeature.WriteDateUseDateFormat));
    }

    @RequestMapping("add")
    @RequiresUser
    @RequiresRoles("xmkeshe")
    @RequiresPermissions("stock:add")
    public void add(Stock vo, HttpServletResponse response, HttpServletRequest request, Integer cou, String drid) {
        // 接收cou
        if (cou >= vo.getCount()) { // 如果现在的药品数量小于等于出库数量可以执行
            if (ValidateUtils.validateEmpty(vo.getTitle()) && ValidateUtils.validateEmpty(vo.getName())) {
                vo.setRegdate(new Date());
                try {
                    if (this.strockService.add(vo, cou, drid)) {
                        try {
                            response.getWriter().print("success");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            response.getWriter().print("error");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
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
        } else {
            try {
                response.getWriter().print("error");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
