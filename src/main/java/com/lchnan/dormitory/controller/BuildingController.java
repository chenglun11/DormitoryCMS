package com.lchnan.dormitory.controller;

import com.github.pagehelper.PageInfo;
import com.lchnan.dormitory.entity.Building;
import com.lchnan.dormitory.entity.User;
import com.lchnan.dormitory.service.BuildingService;
import com.lchnan.dormitory.service.UserService;
import com.lchnan.dormitory.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/building")
public class BuildingController {

	@Autowired
	private BuildingService buildingService;
	@Autowired
	private UserService userService;

	@PostMapping("create")
	public Result create(@RequestBody Building building) {
		int flag = buildingService.create(building);
		if (flag > 0) {
			return Result.ok();
		} else {
			return Result.fail();
		}
	}

	@GetMapping("delete")
	public Result delete(String ids) {
		int flag = buildingService.delete(ids);
		if (flag > 0) {
			return Result.ok();
		} else {
			return Result.fail();
		}
	}

	@PostMapping("update")
	public Result update(@RequestBody Building building) {
		int flag = buildingService.update(building);
		if (flag > 0) {
			return Result.ok();
		} else {
			return Result.fail();
		}
	}

	@GetMapping("detail")
	public Building detail(Integer id) {
		return buildingService.detail(id);
	}

	@PostMapping("query")
	public Map<String, Object> query(@RequestBody Building building, HttpServletRequest request) {
		User param = (User) request.getAttribute("user");
		User loginUser = userService.detail(param.getId());
		if (loginUser.getType() == 1) {//宿管员
			building.setUserId(loginUser.getId());
		}
		PageInfo<Building> pageInfo = buildingService.query(building);
		pageInfo.getList().forEach(entity -> {
			User user = userService.detail(entity.getUserId());
			entity.setUser(user);
		});
		return Result.ok(pageInfo);
	}

}
