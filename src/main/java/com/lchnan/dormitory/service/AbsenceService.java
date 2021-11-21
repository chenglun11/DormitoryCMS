package com.lchnan.dormitory.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lchnan.dormitory.entity.Absence;
import com.lchnan.dormitory.mapper.AbsenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AbsenceService {

	@Autowired
	private AbsenceMapper absenceMapper;

	public int create(Absence absence) {
		return absenceMapper.create(absence);
	}

	public int delete(String ids) {
		String[] arr = ids.split(",");
		int row = 0;
		for (String s : arr) {
			if (!StringUtils.isEmpty(s)) {
				absenceMapper.delete(Integer.parseInt(s));
				row++;
			}
		}
		return row;
	}

	public int delete(Integer id) {
		return absenceMapper.delete(id);
	}

	public int update(Absence absence) {
		return absenceMapper.update(absence);
	}

	public int updateSelective(Absence absence) {
		return absenceMapper.updateSelective(absence);
	}

	public PageInfo<Absence> query(Absence absence) {
		if (absence != null && absence.getPage() != null) {
			PageHelper.startPage(absence.getPage(), absence.getLimit());
		}
		return new PageInfo<Absence>(absenceMapper.query(absence));
	}

	public Absence detail(Integer id) {
		return absenceMapper.detail(id);
	}

	public int count(Absence absence) {
		return absenceMapper.count(absence);
	}
}
