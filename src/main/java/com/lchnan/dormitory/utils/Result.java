package com.lchnan.dormitory.utils;

/**
 * @author admin@lchnan.cn
 * @date 2021/11/16 14:45
 */
public class Result {

    public static final Integer SUCCESS_CODE =200;
    public static final Integer ERROR_CODE = 500;

    private Integer code;
    private String msg;
    private Object data = null;

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

    public static Result ok(Integer code, String msg, Object data){
        return new Result(code, msg, data);
    }

    public static Result ok(String msg,Object data){
        return new Result(SUCCESS_CODE,msg,data);
    }

    public static Result ok(Object data){
        return new Result(SUCCESS_CODE,"操作成功",data);
    }

    public static Result fail(Integer code,String msg){
        return new Result(code,msg);
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

}
