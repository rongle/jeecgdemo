package com.jeecgexcel.dto;

import org.springframework.stereotype.Component;

/**
 * @ClassName: MyuserDTO
 * @Description: TODO
 * @author: handale
 * @date: 2020年08月23日 16:52
 */
@Component
public class MyuserDTO {
    private String carId;
    private String num;
    private Integer capacity;
    private Integer startTime;
    private Integer endTime;

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

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }
}
