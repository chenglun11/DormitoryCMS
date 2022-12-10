package com.lchnan.dormitory.entity;

import com.lchnan.dormitory.utils.Entity;
import org.hibernate.validator.constraints.Length;

import java.util.Date;


/**
 * @author 596183363@qq.com
 * @time 2020-11-21 14:27:15
 */
public class Visit extends Entity {

    /**
     *
     */
    private Integer id;
    /**
     *
     */
    @Length(max = 100)
    private String visitor;
    /**
     *
     */
    @Length(max = 100)
    private String phone;
    /**
     *
     */
    private Integer sex;
    /**
     *
     */
    @Length(max = 100)
    private String idcard;
    /**
     *
     */
    private Integer studentId;
    /**
     *
     */
    private Date visitTime;
    /**
     *
     */
    private Date leaveTime;
    /**
     *
     */
    @Length(max = 200)
    private String remark;

    private Student student;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVisitor() {
        return visitor;
    }

    public void setVisitor(String visitor) {
        this.visitor = visitor;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}