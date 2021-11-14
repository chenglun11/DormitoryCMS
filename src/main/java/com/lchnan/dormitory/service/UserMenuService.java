package com.lchnan.dormitory.service;

import com.yanzhen.mapper.UserMenuMapper;
import com.yanzhen.entity.UserMenu;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserMenuService {

    @Autowired
    private UserMenuMapper userMenuMapper;

    public int create(UserMenu userMenu) {
        return userMenuMapper.create(userMenu);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if(!StringUtils.isEmpty(s)){
                userMenuMapper.delete(Integer.parseInt(s));
            row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return userMenuMapper.delete(id);
    }

    public int update(UserMenu userMenu) {
        return userMenuMapper.update(userMenu);
    }

    public int updateSelective(UserMenu userMenu) {
        return userMenuMapper.updateSelective(userMenu);
    }

    public PageInfo<UserMenu> query(UserMenu userMenu) {
        if(userMenu != null && userMenu.getPage() != null){
            PageHelper.startPage(userMenu.getPage(),userMenu.getLimit());
        }
        return new PageInfo<UserMenu>(userMenuMapper.query(userMenu));
    }

    public UserMenu detail(Integer id) {
        return userMenuMapper.detail(id);
    }

    public int count(UserMenu userMenu) {
        return userMenuMapper.count(userMenu);
    }
}
