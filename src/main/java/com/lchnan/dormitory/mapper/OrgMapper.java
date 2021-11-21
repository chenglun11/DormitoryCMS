package com.lchnan.dormitory.mapper;

import com.lchnan.dormitory.entity.Org;

import java.util.List;

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