package cn.xmkeshe.service.impl;

import cn.xmkeshe.dao.IActionDAO;
import cn.xmkeshe.dao.IAdminDAO;
import cn.xmkeshe.dao.IRoleDAO;
import cn.xmkeshe.service.IAdminService;
import cn.xmkeshe.vo.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class AdminServiceImpl implements IAdminService {
    @Resource
    private IAdminDAO adminDAO;
    @Resource
    private IRoleDAO roleDAO;
    @Resource
    private IActionDAO actionDAO;

    @Override
    public Admin show(String aid) throws Exception {
        return this.adminDAO.findById(aid);
    }

    @Override
    public Map<String, Object> listAuthByAdmin(String aid) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("allRoles", this.roleDAO.findAllRoleFlag(aid));
        map.put("allActions", this.actionDAO.findAllActionFlag(aid));
        return map;
    }

    @Override
    public Map<String, Object> listSplit(int currentPage, int lineSize) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("currentPage", (currentPage - 1) * lineSize);
        result.put("lineSize", lineSize);
        map.put("data", this.adminDAO.findAllBySplit(result));
        map.put("count", this.adminDAO.getAllCount());
        return map;
    }

    @Override
    public boolean insert(Admin vo, Set<Integer> rid) throws Exception {
        if (this.adminDAO.findById(vo.getAid()) == null) {
            vo.setRegdate(new Date());
            vo.setFlag(2); // 只能增加普通管理员
            vo.setLocked(0); // 默认正常状态
            if (this.adminDAO.doCreate(vo)) {
                Iterator<Integer> iter = rid.iterator();
                while (iter.hasNext()) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("aid", vo.getAid());
                    map.put("rid", iter.next());
                    this.adminDAO.doCreateAdminAndRole(map);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateByPassword(String aid, String password) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("aid",aid);
        map.put("password",password);
        return this.adminDAO.doUpdateByPassword(map);
    }
}
