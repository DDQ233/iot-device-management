package app.service.admin.impl;

import app.dao.admin.DeviceDao;
import app.entity.Device;

import java.util.List;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/25 20:24
 */
public class DeviceServiceImpl implements DeviceDao {
    @Override
    public int addDevice(Device device) {
        return 0;
    }

    @Override
    public int deleteDeviceById(String id) {
        return 0;
    }

    @Override
    public int updateDevice(Device device) {
        return 0;
    }

    @Override
    public List<Device> findAllDevice() {
        return null;
    }

    @Override
    public List<Device> finDevice(Device device) {
        return null;
    }

    @Override
    public Device findDeviceById(String id) {
        return null;
    }
}
