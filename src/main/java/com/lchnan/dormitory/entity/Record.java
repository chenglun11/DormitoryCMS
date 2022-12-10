package com.lchnan.dormitory.entity;

import com.lchnan.dormitory.utils.Entity;

import java.util.Date;


/**
 * @author 596183363@qq.com
 * @time 2020-11-21 14:27:15
 */
public class Record extends Entity {

    /**
     *
     */
    private Integer id;
    /**
     *
     */
    private Integer studentId;
    /**
     *
     */
    private Integer dormitoryId;
    /**
     *
     */
    private Integer bedId;
    /**
     * 1入住/2退宿
     */
    private Integer status;
    /**
     *
     */
    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(Integer dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public Integer getBedId() {
        return bedId;
    }

    public void setBedId(Integer bedId) {
        this.bedId = bedId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}