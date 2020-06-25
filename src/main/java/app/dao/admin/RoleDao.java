package app.dao.admin;
import app.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/24 09:08
 */
@Mapper
@Component
public interface RoleDao {
    // 添加角色
    int addRole(Role role);

    // 根据 ID 删除角色
    int deleteRoleById(String id);

    // 更新角色
    int updateRole(Role role);

    // 查询所有角色
    List<Role> findAllRole();

    // 查询角色
    Role findRole(Role role);

    // 根据 ID 查询角色
    Role findRoleById(String id);
}
