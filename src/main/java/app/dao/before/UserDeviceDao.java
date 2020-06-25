package app.dao.before;
import app.entity.UserDevice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/24 09:18
 */
@Mapper
@Component
public interface UserDeviceDao {
    // 用户添加设备
    int addUserDevice(UserDevice userDevice);

    // 用户删除设备
    int deleteUserDeviceById(String userId, String deviceId);

    // 用户更新已添加设备的信息
    int updateUserDevice(UserDevice userDevice);

    // 查询所有已添加的设备
    List<UserDevice> findAllUserDevice(String id);

    // 查询已添加的设备
    // UserDevice findUserDevice(UserDevice userDevice);

    // 根据用户 ID 查询所有已添加的设备
    // UserDevice findUserDeviceByUserId(String id);
}
