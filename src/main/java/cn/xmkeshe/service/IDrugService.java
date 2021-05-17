package cn.xmkeshe.service;

import cn.xmkeshe.vo.Drug;

import java.util.Map;

public interface IDrugService {
    public boolean insert(Drug vo)throws Exception;
    public Map<String ,Object> listSplit(String column,String keyWord,int currentPage, int lineSize)throws Exception;

    public boolean update(String drid)throws Exception;
}
