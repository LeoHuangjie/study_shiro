package com.hj.entity.leave.DTO;

import com.hj.entity.leave.BO.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author huangjie
 * @time 2019-06-20 14:26
 */
@Data
public class LeaveAllInfoDTO implements Serializable {

    private static final long serialVersionUID = 2991748366553063252L;
    /**
     * 教师信息
     */
    private LeaveTeacherInfoBO leaveTeacherInfo;

    /**
     * 请假详情
     */
    private LeaveInfoBO leaveInfo;

    /**
     * 审核信息
     */
    private LeaveAuditInfoBO leaveAuditInfo;

    /**
     * 调课信息 （VIP 1对1）
     */
    private List<LeaveStudentInfoBO> leaveStudentInfoVips;

    /**
     * 调课信息 （班课）
     */
    private List<LeaveStudentInfoBO> leaveStudentInfoOrdinaryClasss;

    /**
     * 撤销信息
     */
    private LeaveUndoInfoBO leaveUndoInfo;

    /**
     * 销假信息
     */
    private LeaveTeaminateInfoBO leaveTeaminateInfo;
}
