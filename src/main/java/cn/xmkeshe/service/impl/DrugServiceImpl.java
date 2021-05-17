package cn.xmkeshe.service.impl;

import cn.xmkeshe.dao.IDrugDAO;
import cn.xmkeshe.service.IDrugService;
import cn.xmkeshe.vo.Drug;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class DrugServiceImpl implements IDrugService {
    @Resource
    private IDrugDAO drugDAO;

    @Override
    public boolean insert(Drug vo) throws Exception {
        return this.drugDAO.doCreate(vo);
    }

    @Override
    public Map<String, Object> listSplit(String column, String keyWord, int currentPage, int lineSize) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("keyWord", "%" + keyWord + "%");
        result.put("column", column);
        result.put("currentPage", (currentPage - 1) * lineSize);
        result.put("lineSize", lineSize);
        map.put("data", this.drugDAO.findAllBySplit(result));
        map.put("count", this.drugDAO.getAllCount(result));
        return map;
    }

    @Override
    public boolean update(String drid) throws Exception {
        return this.drugDAO.doUpdate(drid);
    }
}
