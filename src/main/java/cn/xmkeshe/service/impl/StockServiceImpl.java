package cn.xmkeshe.service.impl;

import cn.xmkeshe.dao.IDrugDAO;
import cn.xmkeshe.dao.IStockDAO;
import cn.xmkeshe.service.IStockService;
import cn.xmkeshe.vo.Stock;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class StockServiceImpl implements IStockService {
    @Resource
    private IDrugDAO drugDAO;
    @Resource
    private IStockDAO stockDAO;
    @Override
    public boolean add(Stock vo, int cou,String drid) throws Exception {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("count",cou - vo.getCount()); // 减少库存数据量
        map.put("drid",drid);
        if(this.drugDAO.doUpdateByCount(map)){
            return this.stockDAO.doCreate(vo);
        }
        return false;
    }

    @Override
    public Map<String, Object> listSplit(String title, int currentPage, int lineSize) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("title", title);
        result.put("currentPage", (currentPage - 1) * lineSize);
        result.put("lineSize", lineSize);
        map.put("data", this.stockDAO.findAllBySplit(result));
        map.put("count", this.stockDAO.getAllCount(result));
        return map;
    }
}
