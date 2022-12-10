package com.lchnan.dormitory.entity;

import com.lchnan.dormitory.utils.Entity;
import org.hibernate.validator.constraints.Length;


/**
 * @author 596183363@qq.com
 * @time 2020-11-21 14:27:15
 */
public class Dormitory extends Entity {

    /**
     *
     */
    private Integer id;
    /**
     *
     */
    @Length(max = 50)
    private String no;
    /**
     *
     */
    private Integer sex;
    /**
     *
     */
    private Integer type;
    /**
     *
     */
    private Integer capacity;
    /**
     *
     */
    private Integer storeyId;
    /**
     *
     */
    private Integer buildingId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getStoreyId() {
        return storeyId;
    }

    public void setStoreyId(Integer storeyId) {
        this.storeyId = storeyId;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }
}