package com.lchnan.dormitory.mapper;

import java.util.List;
import java.util.Map;

import com.lchnan.dormitory.entity.Org;

public interface OrgMapper {

	public int create(Org org);

	public int delete(Integer id);

	public int update(Org org);

	public int updateSelective(Org org);

	public List<Org> query(Org org);

	public Org detail(Integer id);

	public int count(Org org);

	public List<Org> queryOrgBySelectionId(Integer selectionId);
}