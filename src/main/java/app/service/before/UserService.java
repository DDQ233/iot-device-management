package app.service.before;
import app.entity.User;
import org.springframework.stereotype.Service;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/16 11:34
 */
public interface UserService {
    // 用户注册
    int register(User user);

    // 用户登录
    int checkLogin(String id, String pwd);

    // 用户注销账号
    int cancelAccount(String id);

    // 更新用户信息
    int updateUserById(User user);

    // 查询用户
    User findUser(User user);

    // 根据 ID 查询用户
    User findUserById(String id);
}
