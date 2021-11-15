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
public class Org extends Entity{

	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	@Length(max = 0)
	private String name;
	/**
	 * 1学院/2系/3专业/4班级
	 */
	private Integer type;
	/**
	 * 
	 */
	private Integer gradeId;
	/**
	 * 
	 */
	private Integer parentId;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getGradeId() {
		return gradeId;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}