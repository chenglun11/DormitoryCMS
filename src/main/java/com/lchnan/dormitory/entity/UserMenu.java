package com.lchnan.dormitory.entity;

import com.lchnan.dormitory.utils.Entity;


/**
 * @author admin@lchnan.dormitory.cn
 * @time 2021-11-13 12:14:11
 */
public class UserMenu extends Entity {

	/**
	 *
	 */
	private Integer userId;
	/**
	 *
	 */
	private Integer menuId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
}