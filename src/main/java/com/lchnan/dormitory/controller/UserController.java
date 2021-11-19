package com.lchnan.dormitory.controller;

import com.github.pagehelper.PageInfo;
import com.lchnan.dormitory.entity.User;
import com.lchnan.dormitory.service.UserService;
import com.lchnan.dormitory.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Result create(@RequestBody User user){
        int flag = userService.create(user);

        if(flag > 0 ){
            return Result.ok("ok");
        }else {
            return Result.fail();
        }

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
