package com.hj.entity.leave.BO;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huangjie
 * @time 2019-06-19 18:16
 */
@Data
public class LeaveInfoBO implements Serializable {


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
     * 申请人
     */
    private String creatorName;

    /**
     * 申请时间
     */
    private String applyForTime;

}
