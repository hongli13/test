package cn.xmkeshe.service;

import cn.xmkeshe.vo.Admin;

import java.util.Map;
import java.util.Set;

public interface IAdminService {
    /**
     * <li>跟进编号查询数据行</li>
     * @param aid
     * @return
     * @throws Exception
     */
    public Admin show(String aid)throws Exception;

    /**
     * 保存权限数据
     * @param aid
     * @return
     * @throws Exception
     */
    public Map<String,Object> listAuthByAdmin(String aid)throws Exception;

    public Map<String ,Object> listSplit(int currentPage, int lineSize)throws Exception;
    public boolean insert(Admin vo, Set<Integer> rid)throws Exception;

    public boolean updateByPassword(String aid, String password)throws Exception;
}
