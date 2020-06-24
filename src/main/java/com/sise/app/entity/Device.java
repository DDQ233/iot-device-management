package com.sise.app.entity;

import java.util.Date;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/16 11:31
 */
public class Device {
    private String device_id;
    private String device_name;
    private String device_protocol_id;
    private String device_pri_classify_id;
    // private String device_sec_classify_id;
    private Date device_create_time;
    private String device_desc;
    private int device_usage;
    private Protocol protocol;
    private PriClassify priClassify;
    // private SecClassify secClassify;

    public Protocol getProtocol() {
        return protocol;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    public PriClassify getPriClassify() {
        return priClassify;
    }

    public void setPriClassify(PriClassify priClassify) {
        this.priClassify = priClassify;
    }

    // public SecClassify getSecClassify() {
    //     return secClassify;
    // }
    //
    // public void setSecClassify(SecClassify secClassify) {
    //     this.secClassify = secClassify;
    // }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public String getDevice_protocol_id() {
        return device_protocol_id;
    }

    public void setDevice_protocol_id(String device_protocol_id) {
        this.device_protocol_id = device_protocol_id;
    }

    public String getDevice_pri_classify_id() {
        return device_pri_classify_id;
    }

    public void setDevice_pri_classify_id(String device_pri_classify_id) {
        this.device_pri_classify_id = device_pri_classify_id;
    }

    // public String getDevice_sec_classify_id() {
    //     return device_sec_classify_id;
    // }
    //
    // public void setDevice_sec_classify_id(String device_sec_classify_id) {
    //     this.device_sec_classify_id = device_sec_classify_id;
    // }

    public Date getDevice_create_time() {
        return device_create_time;
    }

    public void setDevice_create_time(Date device_create_time) {
        this.device_create_time = device_create_time;
    }

    public String getDevice_desc() {
        return device_desc;
    }

    public void setDevice_desc(String device_desc) {
        this.device_desc = device_desc;
    }

    public int getDevice_usage() {
        return device_usage;
    }

    public void setDevice_usage(int device_usage) {
        this.device_usage = device_usage;
    }
}
