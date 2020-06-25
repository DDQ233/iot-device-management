package app.service.before.impl;

import app.dao.before.UserDeviceDao;
import app.entity.UserDevice;

import java.util.List;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/25 20:25
 */
public class UserDeviceServiceImpl implements UserDeviceDao {
    @Override
    public int addUserDevice(UserDevice userDevice) {
        return 0;
    }

    @Override
    public int deleteUserDeviceById(String userId, String deviceId) {
        return 0;
    }

    @Override
    public int updateUserDevice(UserDevice userDevice) {
        return 0;
    }

    @Override
    public List<UserDevice> findAllUserDevice(String id) {
        return null;
    }
}
