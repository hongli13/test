package cn.xmkeshe.dao;

import cn.xmkeshe.vo.Role;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface IRoleDAO {
    public Set<String> findAllRoleFlag(String aid)throws SQLException;
    public List<Role> findAll()throws SQLException;
}
