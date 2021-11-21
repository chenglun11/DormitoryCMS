package com.lchnan.dormitory.entity;

import com.lchnan.dormitory.utils.Entity;


/**
 * @author 1137050697@qq.com
 * @time 2021-11-21 14:27:15
 */
public class NoticeReceive extends Entity {

	/**
	 *
	 */
	private Integer id;
	/**
	 *
	 */
	private Integer noticeId;
	/**
	 *
	 */
	private Integer buildingId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}
}