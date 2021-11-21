package com.lchnan.dormitory.controller;

import com.github.pagehelper.PageInfo;
import com.lchnan.dormitory.entity.Org;
import com.lchnan.dormitory.service.OrgService;
import com.lchnan.dormitory.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/org")
public class OrgController {

	@Autowired
	private OrgService orgService;

	@GetMapping("tree")
	public Result tree() {
		PageInfo<Org> pageInfo = orgService.query(null);
		//所有的树形数据
		List<Org> list = pageInfo.getList();
		//要构建的树形结构
		List<Map<String, Object>> trees = new ArrayList<>();
		for (Org entity : list) {
			if (entity.getParentId() == 0) {
				Map<String, Object> map = new HashMap<>();
				map.put("id", entity.getId());
				map.put("name", entity.getName());
				if (entity.getType() < 4) {
					map.put("isParent", true);
					map.put("open", true);
					map.put("children", getChild(entity, list));
				} else {
					map.put("isParent", false);
				}
				trees.add(map);
			}
		}
		return Result.ok(trees);
	}

	//自己调自己、有出口
	public List<Map<String, Object>> getChild(Org parent, List<Org> list) {
		List<Map<String, Object>> child = new ArrayList<>();
		for (Org org : list) {
			if (parent.getId() == org.getParentId()) {
				Map<String, Object> map = new HashMap<>();
				map.put("id", org.getId());
				map.put("name", org.getName());
				if (org.getType() < 4) {
					map.put("isParent", true);
					map.put("children", getChild(org, list));
				} else {
					map.put("isParent", false);
				}
				child.add(map);
			}
		}
		return child;
	}


	@PostMapping("create")
	public Result create(@RequestBody Org org) {
		//未设置则为一级栏目
		if (org.getParentId() == null) {
			org.setParentId(0);
		}
		int flag = orgService.create(org);
		if (flag > 0) {
			return Result.ok();
		} else {
			return Result.fail();
		}
	}

	@GetMapping("delete")
	public Result delete(String id) {
		int flag = orgService.delete(id);
		if (flag > 0) {
			return Result.ok();
		} else {
			return Result.fail();
		}
	}

	@PostMapping("update")
	public Result update(@RequestBody Org org) {
		int flag = orgService.update(org);
		if (flag > 0) {
			return Result.ok();
		} else {
			return Result.fail();
		}
	}

	@GetMapping("detail")
	public Org detail(Integer id) {
		return orgService.detail(id);
	}

	@PostMapping("query")
	public Map<String, Object> query(@RequestBody Org org) {
		PageInfo<Org> pageInfo = orgService.query(org);
		return Result.ok(pageInfo);
	}

}
