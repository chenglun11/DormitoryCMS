package com.lchnan.dormitory.mapper;

import com.lchnan.dormitory.entity.Notice;

import java.util.List;

public interface NoticeMapper {

	public int create(Notice notice);

	public int delete(Integer id);

	public int update(Notice notice);

	public int updateSelective(Notice notice);

	public List<Notice> query(Notice notice);

	public Notice detail(Integer id);

	public int count(Notice notice);

}