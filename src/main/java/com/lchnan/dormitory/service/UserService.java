package com.lchnan.dormitory.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lchnan.dormitory.entity.User;
import com.lchnan.dormitory.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author admin@lchnan.cn
 * @date 2021/11/12 17:12
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int create(User user){
        return userMapper.create(user);
    }

    public int delete(Integer id){
        return userMapper.delete(id);
    }

    public int update(User user){
        return userMapper.update(user);
    }

    public PageInfo<User> query(User user){
        if(user !=null && user.getPage() != null){
            PageHelper.startPage(user.getPage(),user.getLimit());
        }
        PageInfo<User> pageInfo = new PageInfo(userMapper.query(user));
        return pageInfo;
    }

    public User detail(Integer id){
        return userMapper.detail(id);
    }

}
