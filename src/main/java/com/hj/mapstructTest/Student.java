package com.hj.mapstructTest;

import lombok.Data;

import java.util.Date;

/**
 * @author huangjie
 * @time 2019-07-17 15:43
 */
@Data
public class Student {
    private Integer id;

    private String name;

    private Integer classId;

    private Integer lessonId;

    private Integer age;

    private Integer sex;

    private Date beginTime;

    private Date endTime;
}
