package com.sdut.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Filename: ResV
 * @Author: SpringForest
 * @Data:2022/9/17 10:26 AM
 * @Description: 一个简单的通用返回类，封装了一些常用的返回值和信息
 */

public class ResV extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public ResV() {
        put("code", 200);
    }

    public static ResV error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static ResV error(String msg) {
        return error(500, msg);
    }

    public static ResV error(int code, String msg) {
        ResV resV = new ResV();
        resV.put("code", code);
        resV.put("msg", msg);
        return resV;
    }

    public static ResV ok(String msg) {
        ResV resV = new ResV();
        resV.put("msg", msg);
        return resV;
    }

    public static ResV ok(Map<String, Object> map) {
        ResV resV = new ResV();
        resV.putAll(map);
        return resV;
    }

    public static ResV ok(String key, Object obj) {
        ResV resV = new ResV();
        resV.put(key, obj);
        return resV;
    }

    public static ResV ok() {
        return new ResV();
    }

    public ResV put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
