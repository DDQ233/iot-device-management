package app.entity;
/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/23 21:19
 */
public class Protocol {
    private String device_protocol_id;
    private String protocol_name;
    private String protocol_desc;

    public String getDevice_protocol_id() {
        return device_protocol_id;
    }

    public void setDevice_protocol_id(String device_protocol_id) {
        this.device_protocol_id = device_protocol_id;
    }

    public String getProtocol_name() {
        return protocol_name;
    }

    public void setProtocol_name(String protocol_name) {
        this.protocol_name = protocol_name;
    }

    public String getProtocol_desc() {
        return protocol_desc;
    }

    public void setProtocol_desc(String protocol_desc) {
        this.protocol_desc = protocol_desc;
    }

    @Override
    public String toString() {
        return "Protocol{" +
                "device_protocol_id='" + device_protocol_id + '\'' +
                ", protocol_name='" + protocol_name + '\'' +
                ", protocol_desc='" + protocol_desc + '\'' +
                '}';
    }
}
