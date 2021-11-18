package com.lchnan.dormitory.mapper;

import com.lchnan.dormitory.entity.Menu;
import com.lchnan.dormitory.entity.User;

import java.util.List;

public interface MenuMapper {



	public List<Menu> query(Integer id);


	List<Menu> queryByType();
}