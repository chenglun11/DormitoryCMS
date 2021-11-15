package com.lchnan.dormitory.controller;

import com.github.pagehelper.PageInfo;
import com.lchnan.dormitory.entity.User;
import com.lchnan.dormitory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin@lchnan.cn
 * @date 2021/11/9 11:23
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("create")
    public void create(){
        User user = new User();
        user.setName("admin");
        user.setUserName("admin");
        user.setPassword("123456");
        userService.create(user);       //对用户进行创建
    }

    @GetMapping("delete")
    public void delete(Integer id){
        userService.delete(id);         //对用户进行删除
    }

    @GetMapping("update")
    public void update(){
        User user = new User();
        user.setName("adminxx");
        user.setUserName("adminxx");
        user.setPassword("123456xx");
        user.setId(1);
        userService.create(user);   //对用户进行修改
    }

    @GetMapping("detail")
    public User detail(Integer id){
        return userService.detail(id);         //对用户进行删除
    }

    @GetMapping("query")
    public PageInfo<User> query(User user){

        return userService.query(user);
    }
}
