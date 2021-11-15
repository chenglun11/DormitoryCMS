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
public class User extends Entity{

	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	@Length(max = 0)
	private String userName;
	/**
	 * 
	 */
	@Length(max = 0)
	private String password;
	/**
	 * 
	 */
	@Length(max = 0)
	private String name;
	/**
	 * 
	 */
	@Length(max = 0)
	private String phone;
	/**
	 * 0管理员/1宿管员
	 */
	private Integer type;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}