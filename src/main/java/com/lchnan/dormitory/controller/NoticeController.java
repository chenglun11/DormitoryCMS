package com.lchnan.dormitory.controller;

import com.github.pagehelper.PageInfo;
import com.lchnan.dormitory.entity.Notice;
import com.lchnan.dormitory.entity.User;
import com.lchnan.dormitory.service.NoticeService;
import com.lchnan.dormitory.service.UserService;
import com.lchnan.dormitory.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	@Autowired
	private UserService userService;

	@PostMapping("create")
	public Result create(@RequestBody Notice notice, HttpServletRequest request) {
		User user = (User) request.getAttribute("user");
		notice.setUserId(user.getId());
		int flag = noticeService.create(notice);
		if (flag > 0) {
			return Result.ok();
		} else {
			return Result.fail();
		}
	}

	@GetMapping("delete")
	public Result delete(String ids) {
		int flag = noticeService.delete(ids);
		if (flag > 0) {
			return Result.ok();
		} else {
			return Result.fail();
		}
	}

	@PostMapping("update")
	public Result update(@RequestBody Notice notice) {
		int flag = noticeService.updateSelective(notice);
		if (flag > 0) {
			return Result.ok();
		} else {
			return Result.fail();
		}
	}

	@GetMapping("detail")
	public Notice detail(Integer id) {
		return noticeService.detail(id);
	}

	@PostMapping("query")
	public Map<String, Object> query(@RequestBody Notice notice) {
		PageInfo<Notice> pageInfo = noticeService.query(notice);
		pageInfo.getList().forEach(entity -> {
			entity.setUser(userService.detail(entity.getUserId()));
		});
		return Result.ok(pageInfo);
	}

}
