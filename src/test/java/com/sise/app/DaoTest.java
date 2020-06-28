package com.sise.app;

import app.entity.UserDevice;
import app.service.before.UserDeviceService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/28 02:53
 */
public class DaoTest {
    @Resource
    private UserDeviceService userDeviceService;

    @Test
    void findAllUserDeviceTest() {
        List<UserDevice> userDeviceList = userDeviceService.findAllUserDevice("user1");
        for (UserDevice userDevice : userDeviceList) {
            System.out.println(userDevice.toString());
        }
    }
}
