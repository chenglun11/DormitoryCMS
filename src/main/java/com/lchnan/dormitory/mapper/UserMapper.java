package com.lchnan.dormitory.mapper;

import com.lchnan.dormitory.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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