package app.dao.admin;

import app.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/16 11:32
 */
@Mapper
@Component
public interface AdminDao {
    // 添加管理员信息
    int addAdmin(Admin admin);

    // 根据 ID 删除管理员信息
    int deleteAdminById(String id);

    // 更新管理员信息
    int updateAdmin(Admin admin);

    // 查询所有管理员信息
    List<Admin> findAllAdmin();

    // 查询管理员信息
    Admin findAdmin(Admin admin);

    // 根据 ID 查询管理员信息
    Admin findAdminById(String id);

    // 根据用户名和密码查询管理员信息
    Admin findAdminByIdAndPwd(String id, String pwd);

}
