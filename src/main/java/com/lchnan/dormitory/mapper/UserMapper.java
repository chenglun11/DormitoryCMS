package com.lchnan.dormitory.mapper;

import java.util.List;
import java.util.Map;

import com.lchnan.dormitory.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

	int create(User user);

	int delete(Integer id);

	int update(User user);

	int updateSelective(User user);

	List<User> query(User user);

	User detail(Integer id);

	User login(@Param("userName") String userName, @Param("password") String password);

	int count(User user);

}