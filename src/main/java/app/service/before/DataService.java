package app.service.before;

import app.entity.Data;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/25 20:49
 */
public interface DataService {
    // 添加数据信息
    int addData(Data data);

    // 根据设备 ID 删除数据
    int deleteDataByDeviceId(String id);

    // 更新数据
    int updateData(Data data);

    // 查询所有数据
    List<Data> findAllData();

    // 查询数据
    Data findData(Data data);

    // 根据设备 ID 查询数据
    Data findDataByDeviceId(String id);

    // 根据日期查询数据
    List<Data> findDataByTime(Date fromDate, Date toDate);
}
