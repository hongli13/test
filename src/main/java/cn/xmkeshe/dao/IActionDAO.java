package cn.xmkeshe.dao;

import java.sql.SQLException;
import java.util.Set;

public interface IActionDAO {
    public Set<String> findAllActionFlag(String aid)throws SQLException;
}
