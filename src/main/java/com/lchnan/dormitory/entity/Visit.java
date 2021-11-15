package com.lchnan.dormitory.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.lchnan.dormitory.utils.Entity;
import java.util.Date;


/**
 * 
 * @author admin@lchnan.cn
 * @time 2021-11-13 12:14:11
 */
public class Visit extends Entity{

	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	@Length(max = 0)
	private String visitor;
	/**
	 * 
	 */
	@Length(max = 0)
	private String phone;
	/**
	 * 
	 */
	private Integer sex;
	/**
	 * 
	 */
	@Length(max = 0)
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
	@Length(max = 0)
	private String remark;

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
}