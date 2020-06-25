package app.service.admin.impl;

import app.dao.admin.DeviceDao;
import app.entity.Device;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/25 20:24
 */
@Service
public class DeviceServiceImpl implements DeviceDao {
    @Resource
    private DeviceDao deviceDao;

    @Override
    public int addDevice(Device device) {
        return deviceDao.addDevice(device);
    }

    @Override
    public int deleteDeviceById(String id) {
        return deviceDao.deleteDeviceById(id);
    }

    @Override
    public int updateDevice(Device device) {
        return deviceDao.updateDevice(device);
    }

    @Override
    public List<Device> findAllDevice() {
        return deviceDao.findAllDevice();
    }

    @Override
    public List<Device> finDevice(Device device) {
        return deviceDao.finDevice(device);
    }

    @Override
    public Device findDeviceById(String id) {
        return deviceDao.findDeviceById(id);
    }
}
