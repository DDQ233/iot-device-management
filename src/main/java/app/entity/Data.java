package app.entity;

import java.util.Date;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/23 21:18
 */
public class Data {
    private String user_id;
    private String device_id;
    private String data;
    private Date datetime;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "Data{" +
                "user_id='" + user_id + '\'' +
                ", device_id='" + device_id + '\'' +
                ", data='" + data + '\'' +
                ", datetime=" + datetime +
                '}';
    }
}
