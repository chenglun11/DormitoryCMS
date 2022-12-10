package com.lchnan.dormitory.mapper;

import java.util.List;
import java.util.Map;

import com.lchnan.dormitory.entity.Dormitory;
import org.apache.ibatis.annotations.Param;

public interface DormitoryMapper {

	public int create(Dormitory dormitory);

	public int delete(Integer id);

	public int update(Dormitory dormitory);

	public int updateSelective(Dormitory dormitory);

	public List<Dormitory> query(Dormitory dormitory);

	public Dormitory detail(Integer id);

	public int count(Dormitory dormitory);

	public int deleteByBuildingIdAndStoryId(@Param("buildingId") Integer buildingId, @Param("storeyId")Integer storeyId);

}