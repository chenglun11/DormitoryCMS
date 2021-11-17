package com.lchnan.dormitory.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lchnan.dormitory.entity.Selection;
import com.lchnan.dormitory.mapper.SelectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SelectionService {

    @Autowired
    private SelectionMapper selectionMapper;

    public int create(Selection selection) {
        return selectionMapper.create(selection);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if(!StringUtils.isEmpty(s)){
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
        return selectionMapper.update(selection);
    }

    public int updateSelective(Selection selection) {
        return selectionMapper.updateSelective(selection);
    }

    public PageInfo<Selection> query(Selection selection) {
        if(selection != null && selection.getPage() != null){
            PageHelper.startPage(selection.getPage(),selection.getLimit());
        }
        return new PageInfo<Selection>(selectionMapper.query(selection));
    }

    public Selection detail(Integer id) {
        return selectionMapper.detail(id);
    }

    public int count(Selection selection) {
        return selectionMapper.count(selection);
    }
}
