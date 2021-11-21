package com.lchnan.dormitory.entity;

import com.lchnan.dormitory.utils.Entity;
import org.hibernate.validator.constraints.Length;

import java.util.Date;


/**
 * @author 1137050697@qq.com
 * @time 2021-11-21 14:27:14
 */
public class Absence extends Entity {

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
	private Date startTime;
	/**
	 *
	 */
	private Date endTime;
	/**
	 *
	 */
	@Length(max = 200)
	private String remark;

	private Student student;

	private Dormitory dormitory;

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

	public Dormitory getDormitory() {
		return dormitory;
	}

	public void setDormitory(Dormitory dormitory) {
		this.dormitory = dormitory;
	}
}