package app.dao.before;
import app.entity.User;
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
public interface UserDao {
    // 添加用户
    int addUser(User user);

    // 删除用户
    int deleteUserById(String id);

    // 更新用户信息
    int updateUser(User user);

    // 修改用户密码
    int updatePassword(String id, String pwd);

    // 查询所有用户
    List<User> findAllUser();

    // 查询用户
    User findUser(User user);

    // 根据 ID 查询用户
    User findUserById(String id);

    // 根据用户名和密码查询用户信息
    User findUserByIdAndPwd(User user);
}
