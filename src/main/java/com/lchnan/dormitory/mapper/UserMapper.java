package com.lchnan.dormitory.mapper;

import java.util.List;
import java.util.Map;

import com.lchnan.dormitory.entity.User;

public interface UserMapper {

	int create(User user);

	int delete(Integer id);

	int update(User user);

	int updateSelective(User user);

	List<User> query(User user);

	User detail(Integer id);

	int count(User user);

}