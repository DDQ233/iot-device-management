package app.service.before;
import app.entity.UserDevice;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/25 20:24
 */
@Service
public interface UserDeviceService {
    // 用户添加设备
    int addUserDevice(UserDevice userDevice);

    // 用户删除设备
    int deleteUserDeviceByAuth(String auth);

    // 用户更新已添加设备的信息
    int updateUserDevice(UserDevice userDevice);

    // 查询所有已添加的设备
    List<UserDevice> findAllUserDevice(String id);

    // 查询用户已添加的设备
    List<UserDevice> findUserDevice(UserDevice userDevice);

    // 根据设备认证/鉴权信息查询设备
    UserDevice findUserDeviceByAuth(String id, String auth);

    // 用户设备计数
    int countDevice(String id);

    // 用户已上线设备计数
    int countOnlineDevice(String id);

    // 查询已添加的设备
    // UserDevice findUserDevice(UserDevice userDevice);

    // 根据用户 ID 查询所有已添加的设备
    // UserDevice findUserDeviceByUserId(String id);
}
