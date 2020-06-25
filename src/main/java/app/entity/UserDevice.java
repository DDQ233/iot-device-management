package app.entity;
/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/23 21:19
 */
public class UserDevice {
    private String user_id;
    private String device_id;
    private String device_status;
    private String device_auth;
    private String device_addr;
    private String device_api;
    private String device_desc;
    private Device device;

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

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

    public String getDevice_status() {
        return device_status;
    }

    public void setDevice_status(String device_status) {
        this.device_status = device_status;
    }

    public String getDevice_auth() {
        return device_auth;
    }

    public void setDevice_auth(String device_auth) {
        this.device_auth = device_auth;
    }

    public String getDevice_addr() {
        return device_addr;
    }

    public void setDevice_addr(String device_addr) {
        this.device_addr = device_addr;
    }

    public String getDevice_api() {
        return device_api;
    }

    public void setDevice_api(String device_api) {
        this.device_api = device_api;
    }

    public String getDevice_desc() {
        return device_desc;
    }

    public void setDevice_desc(String device_desc) {
        this.device_desc = device_desc;
    }
}
