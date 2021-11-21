package com.lchnan.dormitory.entity;

import com.lchnan.dormitory.utils.Entity;
import org.hibernate.validator.constraints.Length;


/**
 * @author 1137050697@qq.com
 * @time 2021-11-21 14:27:15
 */
public class Storey extends Entity {

	/**
	 *
	 */
	private Integer id;
	/**
	 *
	 */
	@Length(max = 100)
	private String name;
	/**
	 *
	 */
	private Integer buildingId;
	/**
	 *
	 */
	@Length(max = 200)
	private String remark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}