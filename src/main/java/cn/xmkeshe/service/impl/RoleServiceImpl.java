package cn.xmkeshe.service.impl;

import cn.xmkeshe.dao.IRoleDAO;
import cn.xmkeshe.service.IRoleService;
import cn.xmkeshe.vo.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Resource
    private IRoleDAO roleDAO;

    @Override
    public List<Role> list() throws Exception {
        return this.roleDAO.findAll();
    }
}
