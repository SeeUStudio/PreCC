package com;

/**
 * Created by neo on 13/01/2017.
 */
public class CODE {
    /**
     * 数据请求返回码
     */
    public static final int SUCCESS = 200;                //成功
    public static final int FAILURE = 400;                //失败
    public static final int EXCEPTION = 500;              //请求抛出异常
    public static final int NOAUTH = 403;                 //无操作权限
    public static final int NOUSER = 404;                //无此账户
    public static final int CREATED = 201;                 //请求已经被实现，而且有一个新的资源已经依据请求的需要而创建
    public static final int ACCEPTED = 202;               //服务器已接受请求，但尚未处理
}
