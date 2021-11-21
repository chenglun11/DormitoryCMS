package com.lchnan.dormitory.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lchnan.dormitory.entity.Org;
import com.lchnan.dormitory.entity.Selection;
import com.lchnan.dormitory.entity.SelectionJoiner;
import com.lchnan.dormitory.mapper.SelectionJoinerMapper;
import com.lchnan.dormitory.mapper.SelectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class SelectionService {

	@Autowired
	private SelectionMapper selectionMapper;
	@Autowired
	private OrgService orgService;

	@Autowired
	private SelectionJoinerMapper selectionJoinerMapper;

	@Transactional
	public int create(Selection selection) {
		selectionMapper.create(selection);
		List<Integer> clazzIds = selection.getClazzIds();
		//筛选出对应的班级
		List<Integer> selectIds = new ArrayList();
		clazzIds.forEach(item -> {
			Org detail = orgService.detail(item);
			if (detail.getType() == 4) {
				selectIds.add(detail.getId());
			}
		});
		selectIds.forEach(item -> {
			SelectionJoiner joiner = new SelectionJoiner();
			joiner.setClazzId(item);
			joiner.setSelectionId(selection.getId());
			selectionJoinerMapper.create(joiner);
		});
		return 1;
	}

	public int delete(String ids) {
		String[] arr = ids.split(",");
		int row = 0;
		for (String s : arr) {
			if (!StringUtils.isEmpty(s)) {
				selectionMapper.delete(Integer.parseInt(s));
				row++;
			}
		}
		return row;
	}

	public int delete(Integer id) {
		return selectionMapper.delete(id);
	}

	public int update(Selection selection) {
		selectionMapper.update(selection);
		//先删除已设置的信息
		selectionJoinerMapper.deleteBySelectionId(selection.getId());
		List<Integer> clazzIds = selection.getClazzIds();
		//筛选出对应的班级
		List<Integer> selectIds = new ArrayList();
		clazzIds.forEach(item -> {
			Org detail = orgService.detail(item);
			if (detail.getType() == 4) {
				selectIds.add(detail.getId());
			}
		});
		selectIds.forEach(item -> {
			SelectionJoiner joiner = new SelectionJoiner();
			joiner.setClazzId(item);
			joiner.setSelectionId(selection.getId());
			selectionJoinerMapper.create(joiner);
		});
		return 1;
	}

	public int updateSelective(Selection selection) {
		return selectionMapper.updateSelective(selection);
	}

	public PageInfo<Selection> query(Selection selection) {
		if (selection != null && selection.getPage() != null) {
			PageHelper.startPage(selection.getPage(), selection.getLimit());
		}
		return new PageInfo<Selection>(selectionMapper.query(selection));
	}

	public List<Selection> queryByClazzId(Integer clazzId) {
		return selectionMapper.queryByClazzId(clazzId);
	}

	public Selection detail(Integer id) {
		return selectionMapper.detail(id);
	}

	public int count(Selection selection) {
		return selectionMapper.count(selection);
	}
}
