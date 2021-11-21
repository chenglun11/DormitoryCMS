package com.lchnan.dormitory.entity;

import com.lchnan.dormitory.utils.Entity;


/**
 * @author 1137050697@qq.com
 * @time 2021-11-21 14:27:15
 */
public class SelectionDormitory extends Entity {

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
	private Integer clazzId;

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

	public Integer getClazzId() {
		return clazzId;
	}

	public void setClazzId(Integer clazzId) {
		this.clazzId = clazzId;
	}
}