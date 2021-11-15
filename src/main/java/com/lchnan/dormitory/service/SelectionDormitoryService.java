package com.lchnan.dormitory.service;

import com.lchnan.dormitory.mapper.SelectionDormitoryMapper;
import com.lchnan.dormitory.entity.SelectionDormitory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SelectionDormitoryService {

    @Autowired
    private SelectionDormitoryMapper selectionDormitoryMapper;

    public int create(SelectionDormitory selectionDormitory) {
        return selectionDormitoryMapper.create(selectionDormitory);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if(!StringUtils.isEmpty(s)){
                selectionDormitoryMapper.delete(Integer.parseInt(s));
            row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return selectionDormitoryMapper.delete(id);
    }

    public int update(SelectionDormitory selectionDormitory) {
        return selectionDormitoryMapper.update(selectionDormitory);
    }

    public int updateSelective(SelectionDormitory selectionDormitory) {
        return selectionDormitoryMapper.updateSelective(selectionDormitory);
    }

    public PageInfo<SelectionDormitory> query(SelectionDormitory selectionDormitory) {
        if(selectionDormitory != null && selectionDormitory.getPage() != null){
            PageHelper.startPage(selectionDormitory.getPage(),selectionDormitory.getLimit());
        }
        return new PageInfo<SelectionDormitory>(selectionDormitoryMapper.query(selectionDormitory));
    }

    public SelectionDormitory detail(Integer id) {
        return selectionDormitoryMapper.detail(id);
    }

    public int count(SelectionDormitory selectionDormitory) {
        return selectionDormitoryMapper.count(selectionDormitory);
    }
}
