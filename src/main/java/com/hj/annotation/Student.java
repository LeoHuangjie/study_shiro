package com.hj.annotation;

import lombok.Data;

/**
 * @author huangjie
 * @time 2019-06-06 11:41
 */
@Data
public class Student {
    private Integer id;

    private Integer age;


    public Student () {
        System.out.println("123");
    }
}
