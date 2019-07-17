package com.hj.entity.leave;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huangjie
 * @time 2019-06-19 17:31
 */
@Data
@Deprecated
public class LeaveStudentInfoBaseDTO implements Serializable {
    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 上课开始时间
     */
    private String orignalLessonStartTime;

    /**
     * 上课结束时间
     */
    private String orignalLessonEndTime;

    /**
     * 上课主题
     */
    private String lessonTheme;


}
