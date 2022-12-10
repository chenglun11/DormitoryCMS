package com.lchnan.dormitory.service;

import com.lchnan.dormitory.mapper.GradeMapper;
import com.lchnan.dormitory.entity.Grade;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class GradeService {

    @Autowired
    private GradeMapper gradeMapper;

    public int create(Grade grade) {
        return gradeMapper.create(grade);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if(!StringUtils.isEmpty(s)){
                gradeMapper.delete(Integer.parseInt(s));
            row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return gradeMapper.delete(id);
    }

    public int update(Grade grade) {
        return gradeMapper.update(grade);
    }

    public int updateSelective(Grade grade) {
        return gradeMapper.updateSelective(grade);
    }

    public PageInfo<Grade> query(Grade grade) {
        if(grade != null && grade.getPage() != null){
            PageHelper.startPage(grade.getPage(),grade.getLimit());
        }
        return new PageInfo<Grade>(gradeMapper.query(grade));
    }

    public Grade detail(Integer id) {
        return gradeMapper.detail(id);
    }

    public int count(Grade grade) {
        return gradeMapper.count(grade);
    }
}
