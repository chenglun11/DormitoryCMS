package com.lchnan.dormitory.service;

import com.lchnan.dormitory.mapper.VisitMapper;
import com.lchnan.dormitory.entity.Visit;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class VisitService {

    @Autowired
    private VisitMapper visitMapper;

    public int create(Visit visit) {
        return visitMapper.create(visit);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if(!StringUtils.isEmpty(s)){
                visitMapper.delete(Integer.parseInt(s));
            row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return visitMapper.delete(id);
    }

    public int update(Visit visit) {
        return visitMapper.update(visit);
    }

    public int updateSelective(Visit visit) {
        return visitMapper.updateSelective(visit);
    }

    public PageInfo<Visit> query(Visit visit) {
        if(visit != null && visit.getPage() != null){
            PageHelper.startPage(visit.getPage(),visit.getLimit());
        }
        return new PageInfo<Visit>(visitMapper.query(visit));
    }

    public Visit detail(Integer id) {
        return visitMapper.detail(id);
    }

    public int count(Visit visit) {
        return visitMapper.count(visit);
    }
}
