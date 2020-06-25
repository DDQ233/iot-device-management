package app.service.admin.impl;

import app.dao.admin.AdminDao;
import app.entity.Admin;

import java.util.List;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/16 11:35
 */
public class AdminServiceImpl implements AdminDao {
    @Override
    public int addAdmin(Admin admin) {
        return 0;
    }

    @Override
    public int deleteAdminById(String id) {
        return 0;
    }

    @Override
    public int updateAdmin(Admin admin) {
        return 0;
    }

    @Override
    public List<Admin> findAllAdmin() {
        return null;
    }

    @Override
    public Admin findAdmin(Admin admin) {
        return null;
    }

    @Override
    public Admin findAdminById(String id) {
        return null;
    }

    @Override
    public Admin findAdminByIdAndPwd(String id, String pwd) {
        return null;
    }
}
