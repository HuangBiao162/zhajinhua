package com.hb.demo.zhajinhua.util;

import com.alibaba.fastjson.JSON;

public class JSONUtil<T> {

    public T transClass(Class targetClass, String jsonString) {

        return (T)JSON.parseObject(jsonString, targetClass);
    }

    public static Object transObject(Class targetClass, String jsonString){
        return JSON.parseObject(jsonString, targetClass);
    }

}
