package app.service.admin.impl;

import app.dao.admin.AdminDao;
import app.entity.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/16 11:35
 */
@Service
public class AdminServiceImpl implements AdminDao {
    @Resource
    private AdminDao adminDao;

    @Override
    public int addAdmin(Admin admin) {
        return adminDao.addAdmin(admin);
    }

    @Override
    public int deleteAdminById(String id) {
        return adminDao.deleteAdminById(id);
    }

    @Override
    public int updateAdmin(Admin admin) {
        return adminDao.updateAdmin(admin);
    }

    @Override
    public int updatePassword(String id, String password){
        return adminDao.updatePassword(id, password);
    }

    @Override
    public List<Admin> findAllAdmin() {
        return adminDao.findAllAdmin();
    }

    @Override
    public Admin findAdmin(Admin admin) {
        return adminDao.findAdmin(admin);
    }

    @Override
    public Admin findAdminById(String id) {
        return adminDao.findAdminById(id);
    }

    @Override
    public Admin findAdminByIdAndPwd(String id, String pwd) {
        return adminDao.findAdminByIdAndPwd(id, pwd);
    }
}
