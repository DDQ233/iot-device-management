package app.service.admin;

import app.entity.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/16 11:34
 */
@Service
public interface AdminService {
    // 管理员注册
    int register(Admin admin);

    // 管理员登录
    Admin checkLogin(String id, String pwd);

    // 根据 ID 删除管理员信息
    int deleteAdminById(String id);

    // 更新管理员信息
    int updateAdmin(Admin admin);

    // 修改管理员密码
    int updatePassword(String id, String password);

    // 查询所有管理员信息
    List<Admin> findAllAdmin();

    // 查询管理员信息
    Admin findAdmin(Admin admin);

    // 根据 ID 查询管理员信息
    Admin findAdminById(String id);
}
