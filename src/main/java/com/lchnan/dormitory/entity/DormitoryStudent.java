package com.lchnan.dormitory.entity;

import com.lchnan.dormitory.utils.Entity;

import java.util.Date;


/**
 * @author 1137050697@qq.com
 * @time 2021-11-21 14:27:15
 */
public class DormitoryStudent extends Entity {

	/**
	 *
	 */
	private Integer id;
	/**
	 *
	 */
	private Integer dormitoryId;
	/**
	 *
	 */
	private Integer bedId;
	/**
	 *
	 */
	private Integer studentId;
	/**
	 *
	 */
	private Date checkin;
	/**
	 * 0待入住/1已入住
	 */
	private Integer status;

	private Student student;

	private Dormitory dormitory;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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