package com.lchnan.dormitory.mapper;

import java.util.List;
import java.util.Map;

import com.lchnan.dormitory.entity.Notice;

public interface NoticeMapper {

	public int create(Notice notice);

	public int delete(Integer id);

	public int update(Notice notice);

	public int updateSelective(Notice notice);

	public List<Notice> query(Notice notice);

	public Notice detail(Integer id);

	public int count(Notice notice);

}