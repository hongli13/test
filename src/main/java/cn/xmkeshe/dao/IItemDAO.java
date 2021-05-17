package cn.xmkeshe.dao;

import cn.xmkeshe.vo.Item;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IItemDAO {
    /**
     * 实现数据增加操作
     *
     * @param vo 表示要执行数据增加的对象
     * @return 增加成功返回true，失败返回false
     * @throws SQLException
     */
    public boolean doCreate(Item vo) throws SQLException;

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
    public Integer getAllCount()throws SQLException;
    public List<Item> findAll()throws SQLException;
}
