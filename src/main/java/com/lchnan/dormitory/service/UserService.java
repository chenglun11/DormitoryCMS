package com.lchnan.dormitory.service;

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

    public List<User> query(User user){
        return userMapper.query(user);
    }

    public User detail(Integer id){
        return userMapper.detail(id);
    }

}
