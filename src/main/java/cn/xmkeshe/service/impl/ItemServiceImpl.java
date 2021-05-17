package cn.xmkeshe.service.impl;

import cn.xmkeshe.dao.IItemDAO;
import cn.xmkeshe.service.IItemService;
import cn.xmkeshe.vo.Item;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements IItemService {
    @Resource
    private IItemDAO iItemDAO;

    @Override
    @RequiresRoles("xmkeshe")
    @RequiresPermissions("xmkeshe:add")
    public boolean add(Item vo) throws Exception {
        return this.iItemDAO.doCreate(vo);
    }

    @Override
    @RequiresRoles("xmkeshe")
    @RequiresPermissions("xmkeshe:list")
    public Map<String, Object> listSplit(int currentPage, int lineSize) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("currentPage", (currentPage - 1) * lineSize);
        result.put("lineSize", lineSize);
        map.put("data", this.iItemDAO.findAllBySplit(result));
        map.put("count", this.iItemDAO.getAllCount());
        return map;
    }

    @Override
    public List<Item> list() throws Exception {
        return this.iItemDAO.findAll();
    }
}
