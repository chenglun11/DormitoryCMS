package com.lchnan.dormitory.mapper;

import java.util.List;
import java.util.Map;

import com.lchnan.dormitory.entity.UserMenu;

public interface UserMenuMapper {

	public int create(UserMenu userMenu);

	public int delete(Integer id);

	public int update(UserMenu userMenu);

	public int updateSelective(UserMenu userMenu);

	public List<UserMenu> query(UserMenu userMenu);

	public UserMenu detail(Integer id);

	public int count(UserMenu userMenu);

}