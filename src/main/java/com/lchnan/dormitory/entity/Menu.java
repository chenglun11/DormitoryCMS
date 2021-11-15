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
public class Menu extends Entity{

	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	@Length(max = 0)
	private String title;
	/**
	 * 
	 */
	@Length(max = 0)
	private String icon;
	/**
	 * 
	 */
	@Length(max = 0)
	private String href;
	/**
	 * 
	 */
	@Length(max = 0)
	private String target;
	/**
	 * 
	 */
	private Integer parentId;
	/**
	 * 0:管理员/宿管员功能：1：学生
	 */
	private Integer type;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
}