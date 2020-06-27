package app.service.before.impl;

import app.dao.before.UserDeviceDao;
import app.entity.UserDevice;
import app.service.before.UserDeviceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/25 20:25
 */
@Service("userDeviceService")
public class UserDeviceServiceImpl implements UserDeviceService {
    @Resource(name = "userDeviceDao")
    private UserDeviceDao userDeviceDao;

    @Override
    public int addUserDevice(UserDevice userDevice) {
        return userDeviceDao.addUserDevice(userDevice);
    }

    @Override
    public int deleteUserDeviceByAuth(String auth) {
        return userDeviceDao.deleteUserDeviceByAuth(auth);
    }

    @Override
    public int updateUserDevice(UserDevice userDevice) {
        return userDeviceDao.updateUserDevice(userDevice);
    }

    @Override
    public List<UserDevice> findAllUserDevice(String id) {
        return userDeviceDao.findAllUserDevice(id);
    }

    @Override
    public List<UserDevice> findUserDevice(UserDevice userDevice) {
        return userDeviceDao.findUserDevice(userDevice);
    }

    @Override
    public UserDevice findUserDeviceByAuth(String auth) {
        return userDeviceDao.findUserDeviceByAuth(auth);
    }

    @Override
    public int countDevice(String id) {
        return userDeviceDao.countDevice(id);
    }

    @Override
    public int countOnlineDevice(String id) {
        return userDeviceDao.countOnlineDevice(id);
    }


}
