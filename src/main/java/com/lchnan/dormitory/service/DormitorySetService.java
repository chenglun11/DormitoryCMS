package com.lchnan.dormitory.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lchnan.dormitory.entity.DormitorySet;
import com.lchnan.dormitory.mapper.DormitorySetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class DormitorySetService {

	@Autowired
	private DormitorySetMapper dormitorySetMapper;

	public int create(DormitorySet dormitorySet) {
		return dormitorySetMapper.create(dormitorySet);
	}

	public int delete(String ids) {
		String[] arr = ids.split(",");
		int row = 0;
		for (String s : arr) {
			if (!StringUtils.isEmpty(s)) {
				dormitorySetMapper.delete(Integer.parseInt(s));
				row++;
			}
		}
		return row;
	}

	public int delete(Integer id) {
		return dormitorySetMapper.delete(id);
	}

	public int update(DormitorySet dormitorySet) {
		return dormitorySetMapper.update(dormitorySet);
	}

	public int updateSelective(DormitorySet dormitorySet) {
		return dormitorySetMapper.updateSelective(dormitorySet);
	}

	public PageInfo<DormitorySet> query(DormitorySet dormitorySet) {
		if (dormitorySet != null && dormitorySet.getPage() != null) {
			PageHelper.startPage(dormitorySet.getPage(), dormitorySet.getLimit());
		}
		return new PageInfo<DormitorySet>(dormitorySetMapper.query(dormitorySet));
	}

	public DormitorySet detail(Integer id) {
		return dormitorySetMapper.detail(id);
	}

	public int count(DormitorySet dormitorySet) {
		return dormitorySetMapper.count(dormitorySet);
	}
}
