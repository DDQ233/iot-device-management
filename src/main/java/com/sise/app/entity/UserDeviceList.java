package com.sise.app.entity;

import java.util.List;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/24 16:31
 */
public class UserDeviceList {
    private User user;
    private List<UserDevice> userDevice;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<UserDevice> getUserDevice() {
        return userDevice;
    }

    public void setUserDevice(List<UserDevice> userDevice) {
        this.userDevice = userDevice;
    }
}
