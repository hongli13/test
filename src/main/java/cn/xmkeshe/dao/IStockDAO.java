package cn.xmkeshe.dao;

import cn.xmkeshe.vo.Item;
import cn.xmkeshe.vo.Stock;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IStockDAO {
    public boolean doCreate(Stock vo)throws SQLException;
    /**
     * 数据查询并且分页
     * @param params 要执行查询的对象数据包括当前页，每页显示记录数。
     * @return
     * @throws SQLException
     */
    public List<Item> findAllBySplit(Map<String, Object> params) throws SQLException;

    /**
     * 数据量统计
     * @return 返回数据量
     * @throws SQLException
     */
    public Integer getAllCount(Map<String, Object> params)throws SQLException;
}
