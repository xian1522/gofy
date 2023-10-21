package com.gofy.common.core.domain;

import com.gofy.common.constant.HttpStatus;

import java.util.HashMap;

public class AjaxResult extends HashMap<String, Object> {

    public static final String CODE = "code";
    public static final String MSG = "msg";
    public static final String DATA = "data";

    public AjaxResult(int code, String message, Object data){
        super.put(CODE, code);
        super.put(MSG, message);
        if(data != null){
            super.put(DATA, data);
        }
    }

    public static AjaxResult success(String message, Object data){
        return new AjaxResult(HttpStatus.SUCCESS, message, data);
    }

    public static AjaxResult success(String message){
        return AjaxResult.success(message, null);
    }

    public static AjaxResult success(){
        return AjaxResult.success("操作成功");
    }


    @Override
    public AjaxResult put(String key, Object value){
        super.put(key, value);
        return this;
    }
}
