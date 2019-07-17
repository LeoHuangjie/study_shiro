package com.hj.leave.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author huangjie
 * @time 2019-06-10 19:15
 */
public enum SystemEnumsGlobal {
    ONE(1,"第一个","One"),
    TWO(2,"第二个","Two"),
    STREE(3,"第三个","Three");

    private Integer id;

    private String message;

    private String code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private SystemEnumsGlobal(Integer id, String message, String code) {
        this.id = id;
        this.message = message;
        this.code = code;
    }

    public static Map<Integer,String> getAllClazz () {
        Map<Integer, String> map = Maps.newHashMap();

        for (SystemEnumsGlobal enumsGlobal : values()) {
            map.put(enumsGlobal.id,"com.hj.common."+enumsGlobal.code);
        }
        return map;
    }
}
