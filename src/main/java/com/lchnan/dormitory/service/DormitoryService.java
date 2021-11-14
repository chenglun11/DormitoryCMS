package com.lchnan.dormitory.service;

import com.yanzhen.mapper.DormitoryMapper;
import com.yanzhen.entity.Dormitory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class DormitoryService {

    @Autowired
    private DormitoryMapper dormitoryMapper;

    public int create(Dormitory dormitory) {
        return dormitoryMapper.create(dormitory);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if(!StringUtils.isEmpty(s)){
                dormitoryMapper.delete(Integer.parseInt(s));
            row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return dormitoryMapper.delete(id);
    }

    public int update(Dormitory dormitory) {
        return dormitoryMapper.update(dormitory);
    }

    public int updateSelective(Dormitory dormitory) {
        return dormitoryMapper.updateSelective(dormitory);
    }

    public PageInfo<Dormitory> query(Dormitory dormitory) {
        if(dormitory != null && dormitory.getPage() != null){
            PageHelper.startPage(dormitory.getPage(),dormitory.getLimit());
        }
        return new PageInfo<Dormitory>(dormitoryMapper.query(dormitory));
    }

    public Dormitory detail(Integer id) {
        return dormitoryMapper.detail(id);
    }

    public int count(Dormitory dormitory) {
        return dormitoryMapper.count(dormitory);
    }
}
