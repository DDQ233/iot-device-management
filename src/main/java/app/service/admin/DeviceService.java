package app.service.admin;
import app.entity.Device;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/25 20:23
 */
public interface DeviceService {

    // 添加设备信息
    int addDevice(Device device);

    // 根据 ID 删除设备信息
    int deleteDeviceById(String id);

    // 更新设备信息
    int updateDevice(Device device);

    // 查询所有设备信息
    List<Device> findAllDevice();

    // 查询设备信息
    List<Device> finDevice(Device device);

    // 根据 ID 查询设备信息
    Device findDeviceById(String id);
}
