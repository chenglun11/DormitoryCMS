package com.lchnan.dormitory.mapper;

import com.lchnan.dormitory.entity.Record;

import java.util.List;

public interface RecordMapper {

	public int create(Record record);

	public int delete(Integer id);

	public int update(Record record);

	public int updateSelective(Record record);

	public List<Record> query(Record record);

	public Record detail(Integer id);

	public int count(Record record);

}