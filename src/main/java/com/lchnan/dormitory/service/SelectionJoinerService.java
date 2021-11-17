package com.lchnan.dormitory.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lchnan.dormitory.entity.SelectionJoiner;
import com.lchnan.dormitory.mapper.SelectionJoinerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SelectionJoinerService {

    @Autowired
    private SelectionJoinerMapper selectionJoinerMapper;

    public int create(SelectionJoiner selectionJoiner) {
        return selectionJoinerMapper.create(selectionJoiner);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if(!StringUtils.isEmpty(s)){
                selectionJoinerMapper.delete(Integer.parseInt(s));
            row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return selectionJoinerMapper.delete(id);
    }

    public int update(SelectionJoiner selectionJoiner) {
        return selectionJoinerMapper.update(selectionJoiner);
    }

    public int updateSelective(SelectionJoiner selectionJoiner) {
        return selectionJoinerMapper.updateSelective(selectionJoiner);
    }

    public PageInfo<SelectionJoiner> query(SelectionJoiner selectionJoiner) {
        if(selectionJoiner != null && selectionJoiner.getPage() != null){
            PageHelper.startPage(selectionJoiner.getPage(),selectionJoiner.getLimit());
        }
        return new PageInfo<SelectionJoiner>(selectionJoinerMapper.query(selectionJoiner));
    }

    public SelectionJoiner detail(Integer id) {
        return selectionJoinerMapper.detail(id);
    }

    public int count(SelectionJoiner selectionJoiner) {
        return selectionJoinerMapper.count(selectionJoiner);
    }
}
