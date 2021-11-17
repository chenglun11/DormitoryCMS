package com.lchnan.dormitory.mapper;

import com.lchnan.dormitory.entity.Storey;

import java.util.List;

public interface StoreyMapper {

	public int create(Storey storey);

	public int delete(Integer id);

	public int update(Storey storey);

	public int updateSelective(Storey storey);

	public List<Storey> query(Storey storey);

	public Storey detail(Integer id);

	public int count(Storey storey);

}