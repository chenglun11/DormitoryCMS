package com.lchnan.dormitory.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lchnan.dormitory.entity.User;
import com.lchnan.dormitory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author admin@lchnan.cn
 * @date 2021/11/12 17:20
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("create")
    public void create(){
        User user = new User();
        user.setUserName("admin");
        user.setName("admin");
        user.setPassword("123456");
        userService.create(user);
    }

    @GetMapping("delete")
    public void delete(Integer id){
        userService.delete(id);
    }

    @GetMapping("update")
    public void update(){
        User user = new User();
        user.setUserName("adminxxx");
        user.setName("adminxxx");
        user.setId(9);
        user.setPassword("123456xxx");
        userService.update(user);
    }

    @GetMapping("query")
    public PageInfo<User> query(User user){
        return userService.query(user);
    }

    @GetMapping("detail")
    public User detail(Integer id){
        return userService.detail(id);
    }
}
