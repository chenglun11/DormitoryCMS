package com.lchnan.dormitory.mapper;

import com.lchnan.dormitory.entity.UserMenu;

import java.util.List;

public interface UserMenuMapper {

	public int create(UserMenu userMenu);

	public int delete(Integer id);

	public int update(UserMenu userMenu);

	public int updateSelective(UserMenu userMenu);

	public List<UserMenu> query(UserMenu userMenu);

	public UserMenu detail(Integer id);

	public int count(UserMenu userMenu);

}