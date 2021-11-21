package com.lchnan.dormitory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lchnan.dormitory.utils.Entity;
import org.hibernate.validator.constraints.Length;

import java.util.List;


/**
 * @author 1137050697@qq.com
 * @time 2021-11-21 14:27:15
 */
public class User extends Entity {
	/**
	 *
	 */
	private Integer id;
	/**
	 *
	 */
	@Length(max = 100)
	private String userName;
	/**
	 *
	 */
	@Length(max = 100)
	private String password;
	/**
	 *
	 */
	@Length(max = 100)
	private String name;
	/**
	 *
	 */
	@Length(max = 100)
	private String phone;
	/**
	 * 0管理员/1宿管员
	 */
	private Integer type;
	/**
	 *
	 */
	@Length(max = 200)
	private String remark;

	private List<Integer> ids;

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

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonProperty
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

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
}