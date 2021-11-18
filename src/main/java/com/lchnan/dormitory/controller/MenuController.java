package com.lchnan.dormitory.controller;

import com.lchnan.dormitory.entity.Menu;
import com.lchnan.dormitory.entity.User;
import com.lchnan.dormitory.mapper.MenuMapper;
import com.lchnan.dormitory.service.MenuService;
import com.lchnan.dormitory.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;

	@GetMapping("/query")
	public Result query(HttpServletRequest request){
		List<Menu> menus = new ArrayList<>();
		if(request.getAttribute("user") != null){
			User user = (User) request.getAttribute("user");
			menus = menuService.query(user.getId());
		}else if(request.getAttribute("student") != null){
			menus = menuService.queryByType();
		}

		List<Menu> menuList1 = new ArrayList<>();
		//找出一级菜单
		for (Menu menu : menus) {
			if(menu.getParentId() == 0){
				menuList1.add(menu);
			}
		}

		//嵌套循环找出关联设置child属性
		for (Menu parent : menuList1) {
			List<Menu> child = new ArrayList<>();
			for (Menu entity : menus) {
				if(parent.getId() == entity.getParentId()){
					child.add(entity);
				}
			}
			parent.setChild(child);
		}

		return Result.ok(menuList1);
	}
}
