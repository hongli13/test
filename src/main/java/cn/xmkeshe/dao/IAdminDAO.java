package cn.xmkeshe.dao;

import cn.xmkeshe.vo.Admin;
import cn.xmkeshe.vo.Item;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IAdminDAO {
    /**
     * <li>通过编号查询数据行记录</li>
     * @param aid 要执行查询的数据行编号
     * @return 查询成功返回该数据行，查询失败返回null
     * @throws SQLException
     */
    public Admin findById(String aid)throws SQLException;
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
    public boolean doCreate(Admin vo)throws SQLException;
    public boolean doCreateAdminAndRole(Map<String, Object> params)throws SQLException;

    public boolean doUpdateByPassword(Map<String, Object> params)throws SQLException;
}
