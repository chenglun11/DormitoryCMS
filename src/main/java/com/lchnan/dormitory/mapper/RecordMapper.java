package com.lchnan.dormitory.mapper;

import java.util.List;
import java.util.Map;

import com.lchnan.dormitory.entity.Record;

public interface RecordMapper {

	public int create(Record record);

	public int delete(Integer id);

	public int update(Record record);

	public int updateSelective(Record record);

	public List<Record> query(Record record);

	public Record detail(Integer id);

	public int count(Record record);

}