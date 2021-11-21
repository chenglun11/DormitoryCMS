package com.lchnan.dormitory.entity;

import com.lchnan.dormitory.utils.Entity;
import org.hibernate.validator.constraints.Length;

import java.util.Date;


/**
 * @author 1137050697@qq.com
 * @time 2021-11-21 14:27:15
 */
public class Repair extends Entity {

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
	private Integer buildingId;
	/**
	 *
	 */
	@Length(max = 500)
	private String description;
	/**
	 *
	 */
	private Date createDate;
	/**
	 * 0待解决/1已解决
	 */
	private Integer status;

	private Student student;

	private Dormitory dormitory;

	private Building building;

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

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}
}