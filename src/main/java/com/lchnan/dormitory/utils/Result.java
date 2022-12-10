package com.lchnan.dormitory.utils;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.Map;

public class Result {

    public static final Integer SUCCESS_CODE = 200;
    public static final Integer TOKEN_ERROR = 400;
    public static final Integer ERROR_CODE = 500;

    private Integer code;
    private String msg;
    private Object data = null;

    public static Map<String,Object> ok(PageInfo pageInfo){
        Map<String,Object> map = new HashMap<>();
        map.put("code",SUCCESS_CODE);
        map.put("msg","查询成功");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;
    }

    public static Result ok(Integer status,String msg,Object data){
        return new Result(status,msg,data);
    }

    public static Result ok(String msg,Object data){
        return new Result(SUCCESS_CODE,msg,data);
    }

    public static Result ok(Object data){
        return new Result(SUCCESS_CODE,"操作成功",data);
    }
    public static Result ok(){
        return new Result(SUCCESS_CODE,"操作成功",null);
    }

    public static Result fail(Integer status,String msg){
        return new Result(status,msg);
    }

    public static Result fail(String msg){
        return new Result(ERROR_CODE,msg);
    }

    public static Result fail(){
        return new Result(ERROR_CODE,"操作失败");
    }


    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
