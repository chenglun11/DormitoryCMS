package com.lchnan.dormitory.service;

import com.lchnan.dormitory.mapper.MenuMapper;
import com.lchnan.dormitory.entity.Menu;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    public List<Menu> query(Integer userId){
        return menuMapper.query(userId);
    }
    public List<Menu> list(){
        return menuMapper.list();
    }

    public List<Integer> queryCheckMenuId(Integer userId){
        return menuMapper.queryCheckMenuId(userId);
    }

    public List<Menu> queryByType(){
        return menuMapper.queryByType();
    }

}
