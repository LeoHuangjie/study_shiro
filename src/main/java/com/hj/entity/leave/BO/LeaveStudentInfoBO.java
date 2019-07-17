package com.hj.entity.leave.BO;

import com.hj.entity.leave.LeaveStudentInfoBaseDTO;
import lombok.Data;

import java.io.Serializable;

/**
 * @author huangjie
 * @time 2019-06-20 11:22
 */
@Data
public class LeaveStudentInfoBO extends LeaveStudentInfoBaseDTO implements Serializable {
    /**
     * 学员姓名
     */
    private String studentName;

    /**
     * 原上课时间
     */
    private String orignalLessonStartTime;

    /**
     * 原下课时间
     */
    private String orignalLessonEndTime;

    /**
     * 调课申请
     */
//    private String classSwitchInfo;
    /**
     * 调课开始时间
     */
    private String classSwitchBeginTime;

    /**
     * 调课结束时间
     */
    private String classSwitchEndTime;

    /**
     * 调课申请状态 (0:调课，1:待定)
     */
    private Integer classeApply;

    /**
     * 教师扣除
     */
    private Double teacherDeduct;

    /**
     * 学员赔偿
     */
    private Double studentCompensation;

    /**
     * 上课主题
     */
    private String lessonTheme;

    /**
     * 调课状态 (0:待调课，1：取消，2：新增)
     */
    private Integer classSwitchStatus;

    /**
     * 调课结果
     */
    private String classSwitchResult;

    /**
     * 上课记录ID
     */
    private Integer lessonId;

    /**
     * 教师ID
     */
    private Integer teacherId;

    /**
     * 请假唯一ID
     */
    private Integer leaveId;
}
