package app.service.before.impl;


import app.dao.before.DataDao;
import app.entity.Data;
import app.service.before.DataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/25 21:07
 */
@Service("dataService")
public class DataServiceImpl implements DataService {
    @Resource(name = "dataDao")
    private DataDao dataDao;

    @Override
    public int addData(Data data) {
        return dataDao.addData(data);
    }

    @Override
    public int deleteDataByDeviceId(String id) {
        return dataDao.deleteDataByDeviceId(id);
    }

    @Override
    public int updateData(Data data) {
        return dataDao.updateData(data);
    }

    @Override
    public List<Data> findAllData() {
        return dataDao.findAllData();
    }

    @Override
    public Data findData(Data data) {
        return dataDao.findData(data);
    }

    @Override
    public Data findDataByDeviceId(String id) {
        return dataDao.findDataByDeviceId(id);
    }

    @Override
    public List<Data> findDataByTime(Date fromDate, Date toDate) {
        return dataDao.findDataByTime(fromDate, toDate);
    }
}
