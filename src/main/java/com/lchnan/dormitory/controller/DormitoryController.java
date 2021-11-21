package com.lchnan.dormitory.controller;

import com.github.pagehelper.PageInfo;
import com.lchnan.dormitory.entity.Dormitory;
import com.lchnan.dormitory.service.DormitoryService;
import com.lchnan.dormitory.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/dormitory")
public class DormitoryController {

	@Autowired
	private DormitoryService dormitoryService;

	@PostMapping("create")
	public Result create(@RequestBody Dormitory dormitory) {
		int flag = dormitoryService.create(dormitory);
		if (flag > 0) {
			return Result.ok();
		} else {
			return Result.fail();
		}
	}

	@GetMapping("delete")
	public Result delete(String ids) {
		int flag = dormitoryService.delete(ids);
		if (flag > 0) {
			return Result.ok();
		} else {
			return Result.fail();
		}
	}

	@PostMapping("update")
	public Result update(@RequestBody Dormitory dormitory) {
		int flag = dormitoryService.update(dormitory);
		if (flag > 0) {
			return Result.ok();
		} else {
			return Result.fail();
		}
	}

	@GetMapping("detail")
	public Dormitory detail(Integer id) {
		return dormitoryService.detail(id);
	}

	@PostMapping("query")
	public Map<String, Object> query(@RequestBody Dormitory dormitory) {
		PageInfo<Dormitory> pageInfo = dormitoryService.query(dormitory);
		return Result.ok(pageInfo);
	}

	@PostMapping("init")
	public Result init(@RequestBody Dormitory dormitory) {
		dormitoryService.init(dormitory);
		return Result.ok();
	}

}
