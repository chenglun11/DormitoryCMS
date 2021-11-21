package com.lchnan.dormitory.controller;

import com.github.pagehelper.PageInfo;
import com.lchnan.dormitory.entity.Bed;
import com.lchnan.dormitory.service.BedService;
import com.lchnan.dormitory.service.DormitoryStudentService;
import com.lchnan.dormitory.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/bed")
public class BedController {

	@Autowired
	private BedService bedService;
	@Autowired
	private DormitoryStudentService dormitoryStudentService;

	@PostMapping("create")
	public Result create(@RequestBody Bed bed) {
		int flag = bedService.create(bed);
		if (flag > 0) {
			return Result.ok();
		} else {
			return Result.fail();
		}
	}

	@GetMapping("delete")
	public Result delete(String ids) {
		int flag = bedService.delete(ids);
		if (flag > 0) {
			return Result.ok();
		} else {
			return Result.fail();
		}
	}

	@PostMapping("update")
	public Result update(@RequestBody Bed bed) {
		int flag = bedService.update(bed);
		if (flag > 0) {
			return Result.ok();
		} else {
			return Result.fail();
		}
	}

	@GetMapping("detail")
	public Bed detail(Integer id) {
		return bedService.detail(id);
	}

	@PostMapping("query")
	public Map<String, Object> query(@RequestBody Bed bed) {
		PageInfo<Bed> pageInfo = bedService.query(bed);
		pageInfo.getList().forEach(entity -> {
			entity.setStudent(dormitoryStudentService.queryStudentByBedId(entity.getId()));
		});
		return Result.ok(pageInfo);
	}

}
