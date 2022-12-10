package com.lchnan.dormitory.mapper;

import java.util.List;
import java.util.Map;

import com.lchnan.dormitory.entity.DormitoryStudent;
import org.apache.ibatis.annotations.Param;

public interface DormitoryStudentMapper {

	public int create(DormitoryStudent dormitoryStudent);

	public int delete(Integer id);

	public int deleteByCond(@Param("studentId") Integer studentId, @Param("dormitoryId")Integer dormitoryId);

	public int update(DormitoryStudent dormitoryStudent);

	public int updateSelective(DormitoryStudent dormitoryStudent);

	public List<DormitoryStudent> query(DormitoryStudent dormitoryStudent);

	public DormitoryStudent detail(Integer id);

	public int count(DormitoryStudent dormitoryStudent);

	public int countByBuildingId(Integer buildingId);

	public Map<String,Object> queryStudentByBedId(Integer bedId);

}