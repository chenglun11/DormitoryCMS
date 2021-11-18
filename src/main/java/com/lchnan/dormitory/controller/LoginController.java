package com.lchnan.dormitory.controller;

import com.lchnan.dormitory.entity.User;
import com.lchnan.dormitory.framework.jwt.JwtUtil;
import com.lchnan.dormitory.service.UserService;
import com.lchnan.dormitory.utils.Result;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin@lchnan.cn
 * @date 2021/11/16 11:29
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user){

        User entity = userService.login(user.getUserName(), user.getPassword());
        if(entity != null) {
            String token = JwtUtil.sign(entity);
            Map map = new HashMap();
            map.put(JwtUtil.token,token);
            map.put("user",entity);
            return Result.ok("登录成功", map);
        }else {
            return Result.fail("用户名或密码错误");
        }
    }
}
