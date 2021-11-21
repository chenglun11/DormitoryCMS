package com.lchnan.dormitory.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lchnan.dormitory.entity.User;
import com.lchnan.dormitory.mapper.MenuMapper;
import com.lchnan.dormitory.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private MenuMapper menuMapper;
	/*创建新用户*/
	public int create(User user) {
		//保存到中间表
		int row = 0;
		userMapper.create(user);
		for (Integer menuId : user.getIds()) {
			menuMapper.createUserMenu(user.getId(), menuId);
		}
		row = 1;
		return row;
	}
	/*以用户id批量删除用户*/
	public int delete(String ids) {
		String[] arr = ids.split(",");
		int row = 0;
		for (String s : arr) {
			if (!StringUtils.isEmpty(s)) {
				menuMapper.deleteUserMenu(Integer.parseInt(s));
				userMapper.delete(Integer.parseInt(s));
				row++;
			}
		}
		return row;
	}
	/*以用户id删除用户*/
	public int delete(Integer id) {
		menuMapper.deleteUserMenu(id);
		return userMapper.delete(id);
	}
	/*更新用户信息*/
	public int update(User user) {
		int row = 0;
		userMapper.update(user);
		menuMapper.deleteUserMenu(user.getId());
		for (Integer menuId : user.getIds()) {
			menuMapper.createUserMenu(user.getId(), menuId);
		}
		row = 1;
		return row;
	}
	/*更新密码*/
	public int updatePwd(User user) {
		return userMapper.updateSelective(user);
	}
	/*更新用户权限*/
	public int updateSelective(User user) {
		int row = 0;
		userMapper.updateSelective(user);
		menuMapper.deleteUserMenu(user.getId());
		for (Integer menuId : user.getIds()) {
			menuMapper.createUserMenu(user.getId(), menuId);
		}
		row = 1;
		return row;
	}
	/*使用分页全局查询*/
	public PageInfo<User> query(User user) {
		if (user != null && user.getPage() != null) {
			PageHelper.startPage(user.getPage(), user.getLimit());
		}
		return new PageInfo<User>(userMapper.query(user));
	}
	/*传出登录参数*/
	public User login(String userName, String password) {
		return userMapper.login(userName, password);
	}
	/*查询详细信息*/
	public User detail(Integer id) {
		return userMapper.detail(id);
	}
	/*计数*/
	public int count(User user) {
		return userMapper.count(user);
	}
}
