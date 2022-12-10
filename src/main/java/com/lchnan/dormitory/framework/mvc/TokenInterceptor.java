package com.lchnan.dormitory.framework.mvc;

import com.lchnan.dormitory.entity.Student;
import com.lchnan.dormitory.entity.User;
import com.lchnan.dormitory.framework.exception.MyException;
import com.lchnan.dormitory.framework.jwt.JWTUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(JWTUtil.token);

        String type = JWTUtil.getType(token);
        if("USER".equals(type)){
            //根据token获取user对象
            User user = JWTUtil.getUser(token);
            if(user == null){
                throw  new MyException("超时或不合法的token");
            }
            String newToken = JWTUtil.sign(user);
            response.setHeader(JWTUtil.token,newToken);
            response.setHeader("Access-Control-Expose-Headers", JWTUtil.token);
            request.setAttribute("user",user);
        }else if("STUDENT".equals(type)){
            //根据token获取user对象
            Student student = JWTUtil.getStudent(token);
            if(student == null){
                throw  new MyException("超时或不合法的token");
            }
            String newToken = JWTUtil.signForStudent(student);
            response.setHeader(JWTUtil.token,newToken);
            response.setHeader("Access-Control-Expose-Headers", JWTUtil.token);
            request.setAttribute("student",student);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
