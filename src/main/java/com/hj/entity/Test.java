package com.hj.entity;

import java.io.Serializable;

/**
 * @author huangjie
 * @time 2019-05-13 20:14
 */
public class Test implements Serializable {

    private static final long serialVersionUID = -7051679422806649985L;
    private Integer id;

    private String name;

    private Integer sex;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
