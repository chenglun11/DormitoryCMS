package com.lchnan.dormitory.mapper;

import com.lchnan.dormitory.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {

	public List<Menu> query(Integer userId);

	public List<Menu> queryByType();

	public List<Menu> list();

	public int createUserMenu(@Param("userId") Integer userId, @Param("menuId") Integer menuId);

	public int deleteUserMenu(@Param("userId") Integer userId);

	public List<Integer> queryCheckMenuId(Integer userId);

}