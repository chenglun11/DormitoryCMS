package com.lchnan.dormitory.controller;

import com.github.pagehelper.PageInfo;
import com.lchnan.dormitory.entity.NoticeReceive;
import com.lchnan.dormitory.service.NoticeReceiveService;
import com.lchnan.dormitory.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/noticeReceive")
public class NoticeReceiveController {

	@Autowired
	private NoticeReceiveService noticeReceiveService;

	@PostMapping("create")
	public Result create(@RequestBody NoticeReceive noticeReceive) {
		int flag = noticeReceiveService.create(noticeReceive);
		if (flag > 0) {
			return Result.ok();
		} else {
			return Result.fail();
		}
	}

	@GetMapping("delete")
	public Result delete(String ids) {
		int flag = noticeReceiveService.delete(ids);
		if (flag > 0) {
			return Result.ok();
		} else {
			return Result.fail();
		}
	}

	@PostMapping("update")
	public Result update(@RequestBody NoticeReceive noticeReceive) {
		int flag = noticeReceiveService.update(noticeReceive);
		if (flag > 0) {
			return Result.ok();
		} else {
			return Result.fail();
		}
	}

	@GetMapping("detail")
	public NoticeReceive detail(Integer id) {
		return noticeReceiveService.detail(id);
	}

	@PostMapping("query")
	public Map<String, Object> query(@RequestBody NoticeReceive noticeReceive) {
		PageInfo<NoticeReceive> pageInfo = noticeReceiveService.query(noticeReceive);
		return Result.ok(pageInfo);
	}

}
