package cn.xmkeshe.service;

import cn.xmkeshe.vo.Stock;

import java.util.Map;

public interface IStockService {
    public boolean add(Stock vo,int cou,String drid)throws Exception;
    public Map<String ,Object> listSplit(String title, int currentPage, int lineSize)throws Exception;

}
