package com.hj.mapstructTest;

import lombok.Data;

/**
 * @author huangjie
 * @time 2019-07-17 15:44
 */
@Data
public class StudentDto {
    private Integer studentId;

    private String studentName;

    private String beginTime;

    private String endTime;

    private Integer lessonId;

    private Integer classId;

    private Integer sex;
}
