package com.hj.entity.leave.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huangjie
 * @time 2019-06-19 14:44
 */
@Data
public class LeaveListBaseDTO implements Serializable {

    private static final long serialVersionUID = 426101536371523637L;
    /**
     * 请假唯一主键
     */
    private Integer id;

    /**
     * 请假人id
     */
    private Integer teacherId;

    /**
     * 请假审核状态 (0:待审核，1：审核通过，2：已驳回，3：已撤销)
     */
    private Integer leaveStatus;

    /**
     * 申请时间
     */
    private String applyForTime;

    /**
     * 申请人id
     */
    private Integer creatorUserId;

    /**
     * 申请人姓名
     */
    private String creatorName;

    /**
     * 审核人id
     */
    private Integer auditUserId;

    /**
     * 审核人姓名
     */
    private String auditUserName;

    /**
     * 审核时间
     */
    private String auditTime;

    /**
     * 请假开始时间
     */
    private String leaveBeginTime;

    /**
     * 请假结束时间
     */
    private String leaveEndTime;
}
