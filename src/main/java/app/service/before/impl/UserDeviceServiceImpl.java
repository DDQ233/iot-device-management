package app.service.before.impl;

import app.dao.before.UserDeviceDao;
import app.entity.UserDevice;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/25 20:25
 */
public class UserDeviceServiceImpl implements UserDeviceDao {
    @Resource
    private UserDeviceDao userDeviceDao;

    @Override
    public int addUserDevice(UserDevice userDevice) {
        return userDeviceDao.addUserDevice(userDevice);
    }

    @Override
    public int deleteUserDeviceById(String userId, String deviceId) {
        return userDeviceDao.deleteUserDeviceById(userId, deviceId);
    }

    @Override
    public int updateUserDevice(UserDevice userDevice) {
        return userDeviceDao.updateUserDevice(userDevice);
    }

    @Override
    public List<UserDevice> findAllUserDevice(String id) {
        return userDeviceDao.findAllUserDevice(id);
    }
}
