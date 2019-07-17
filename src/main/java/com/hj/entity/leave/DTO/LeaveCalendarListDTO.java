package com.hj.entity.leave.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huangjie
 * @time 2019-06-19 15:08
 * 日程表 - 我的请假
 */
@Data
public class LeaveCalendarListDTO implements Serializable {
    private static final long serialVersionUID = 4692794775247871312L;
    private Integer id;

    /**
     * 请假开始时间
     */
    private String leaveBeginTime;

    /**
     * 请假结束时间
     */
    private String leaveEndTime;

    /**
     * 请假原因
     */
    private String leaveReason;

    /**
     * 申请时间
     */
    private String applyForTime;

    /**
     * 请假审核状态 (0:待审核，1：审核通过，2：已驳回，3：已撤销)
     */
    private Integer leaveStatus;
}
