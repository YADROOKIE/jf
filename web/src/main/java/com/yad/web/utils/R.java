package com.yad.web.utils;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class R {
    private  Boolean success;
    private Integer code;
    private String  message;
    private Map<String,Object> data = new HashMap();
    private R(){}

    public  static R ok(){
        R r = new R();
        r.success = true;
        r.code = ResultCode.SUCCESS;
        r.message = "成功";
        return  r;
    }

    public  static R error(){
        R r = new R();
        r.success = false;
        r.code = ResultCode.ERROR;
        r.message = "失败";
        return  r;
    }

    //其他值设置  都返回 R 本身
    //链式编程 R.ok().code()......
    public R success(Boolean success){
        this.setSuccess(success);
        return  this;
    }
    public R message(String message){
        this.setMessage(message);
        return  this;
    }
    public R code(Integer code ){
        this.setCode(code);
        return  this;
    }
    public R data(String k , Object v){
        this.data.put(k,v);
        return  this;
    }
    public R data(Map<String,Object> map){
        this.data = map;
        return  this;
    }

}
