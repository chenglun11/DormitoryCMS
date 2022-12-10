package com.lchnan.dormitory.mapper;

import java.util.List;
import java.util.Map;

import com.lchnan.dormitory.entity.SelectionDormitory;

public interface SelectionDormitoryMapper {

	public int create(SelectionDormitory selectionDormitory);

	public int delete(Integer id);

	public int deleteByClazzId(Integer clazzId);

	public int update(SelectionDormitory selectionDormitory);

	public int updateSelective(SelectionDormitory selectionDormitory);

	public List<SelectionDormitory> query(SelectionDormitory selectionDormitory);

	public SelectionDormitory detail(Integer id);

	public int count(SelectionDormitory selectionDormitory);

}