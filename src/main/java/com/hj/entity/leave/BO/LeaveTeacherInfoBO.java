package com.hj.entity.leave.BO;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huangjie
 * @time 2019-06-20 14:00
 */
@Data
public class LeaveTeacherInfoBO implements Serializable {

    /**
     * 教师真实姓名
     */
    private String teacherRealName;

    /**
     * 教师编号
     */
    private String teacherCode;

    /**
     * 用户名
     */
    private String teacherUserName;

    /**
     * 性别 （1：男，2：女）
     */
    private Integer sex;

    /**
     * 教师性质 (1：兼职，2：全职，3：渠道老师)
     */
    private Integer teacherNature;

    /**
     * 教师类型 (0:外教，1：中教)
     */
    private Integer teacherType;

    /**
     * 教师id
     */
    private Integer teacherId;
}
