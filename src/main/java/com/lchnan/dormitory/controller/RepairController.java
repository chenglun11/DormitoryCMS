package com.lchnan.dormitory.controller;

import com.github.pagehelper.PageInfo;
import com.lchnan.dormitory.entity.Repair;
import com.lchnan.dormitory.service.BuildingService;
import com.lchnan.dormitory.service.DormitoryService;
import com.lchnan.dormitory.service.RepairService;
import com.lchnan.dormitory.service.StudentService;
import com.lchnan.dormitory.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/repair")
public class RepairController {

	@Autowired
	private RepairService repairService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private DormitoryService dormitoryService;
	@Autowired
	private BuildingService buildingService;

	@PostMapping("create")
	public Result create(@RequestBody Repair repair) {
		int flag = repairService.create(repair);
		if (flag > 0) {
			return Result.ok();
		} else {
			return Result.fail();
		}
	}

	@GetMapping("delete")
	public Result delete(String ids) {
		int flag = repairService.delete(ids);
		if (flag > 0) {
			return Result.ok();
		} else {
			return Result.fail();
		}
	}

	@PostMapping("update")
	public Result update(@RequestBody Repair repair) {
		int flag = repairService.updateSelective(repair);
		if (flag > 0) {
			return Result.ok();
		} else {
			return Result.fail();
		}
	}

	@GetMapping("detail")
	public Repair detail(Integer id) {
		return repairService.detail(id);
	}

	@PostMapping("query")
	public Map<String, Object> query(@RequestBody Repair repair) {
		PageInfo<Repair> pageInfo = repairService.query(repair);
		pageInfo.getList().forEach(entity -> {
			entity.setBuilding(buildingService.detail(entity.getBuildingId()));
			entity.setStudent(studentService.detail(entity.getStudentId()));
			entity.setDormitory(dormitoryService.detail(entity.getDormitoryId()));
		});
		return Result.ok(pageInfo);
	}

}
