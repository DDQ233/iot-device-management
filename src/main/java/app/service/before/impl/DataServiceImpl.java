package app.service.before.impl;


import app.dao.before.DataDao;
import app.entity.Data;

import java.util.Date;
import java.util.List;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/25 21:07
 */
public class DataServiceImpl implements DataDao {
    @Override
    public int addData(Data data) {
        return 0;
    }

    @Override
    public int deleteDataByDeviceId(String id) {
        return 0;
    }

    @Override
    public int updateData(Data data) {
        return 0;
    }

    @Override
    public List<Data> findAllData() {
        return null;
    }

    @Override
    public Data findData(Data data) {
        return null;
    }

    @Override
    public Data findDataByDeviceId(String id) {
        return null;
    }

    @Override
    public List<Data> findDataByTime(Date fromDate, Date toDate) {
        return null;
    }
}
