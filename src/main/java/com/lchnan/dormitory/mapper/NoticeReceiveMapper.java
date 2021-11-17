package com.lchnan.dormitory.mapper;

import com.lchnan.dormitory.entity.NoticeReceive;

import java.util.List;

public interface NoticeReceiveMapper {

	public int create(NoticeReceive noticeReceive);

	public int delete(Integer id);

	public int update(NoticeReceive noticeReceive);

	public int updateSelective(NoticeReceive noticeReceive);

	public List<NoticeReceive> query(NoticeReceive noticeReceive);

	public NoticeReceive detail(Integer id);

	public int count(NoticeReceive noticeReceive);

}