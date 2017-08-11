package com.gonyb.http;

/**
 * 统一接口返回对象
 * Created by Gonyb on 2017/8/10.
 */
public class DoResult<T> {
    private int code;
    private String msg;
    private T data;

    public DoResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T>DoResult SUCCESS(String msg, T t){
        return new DoResult<>(0,msg,t);
    }
    public static <T>DoResult SUCCESS(T t){
        return new DoResult<>(0,"成功",t);
    }
    public static DoResult SUCCESS(){
        return new DoResult<>(0,"成功","");
    }
    public static DoResult FAILED(int code,String msg){
        return new DoResult<>(code,msg,"");
    }
    public static DoResult FAILED(String msg){
        return new DoResult<>(1,msg,"");
    }
    public static DoResult FAILED(){
        return new DoResult<>(1,"失败","");
    }
    public boolean hsaSuccess(){
        return getCode()==0;
    }
    
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
