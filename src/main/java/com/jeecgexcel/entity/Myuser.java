package com.jeecgexcel.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (Myuser)实体类
 *
 * @author makejava
 * @since 2020-08-23 14:46:29
 */
@Data
public class Myuser implements Serializable {
    private static final long serialVersionUID = -66592582060038769L;

    private Integer id;

    private String carId;

    private String num;

    private Integer capacity;

    private Date startTime;

    private Date endTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}