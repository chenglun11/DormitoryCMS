package com.lchnan.dormitory.controller;

import com.lchnan.dormitory.entity.Student;
import com.lchnan.dormitory.entity.User;
import com.lchnan.dormitory.framework.jwt.JWTUtil;
import com.lchnan.dormitory.service.StudentService;
import com.lchnan.dormitory.service.UserService;
import com.lchnan.dormitory.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        if(user.getType() == 2){ //学生登录的
            Student entity = studentService.login(user.getUserName(),user.getPassword());
            if(entity != null){
                String token = JWTUtil.signForStudent(entity);
                Map map = new HashMap();
                map.put(JWTUtil.token,token);
                map.put("student",entity);
                return Result.ok("登陆成功",map);
            }else{
                return Result.fail("用户名或密码错误");
            }
        }else{//管理员与宿管员登录
            User entity = userService.login(user.getUserName(),user.getPassword());
            if(entity != null){
                String token = JWTUtil.sign(entity);
                Map map = new HashMap();
                map.put(JWTUtil.token,token);
                map.put("user",entity);
                return Result.ok("登陆成功",map);
            }else{
                return Result.fail("用户名或密码错误");
            }
        }
    }

}
