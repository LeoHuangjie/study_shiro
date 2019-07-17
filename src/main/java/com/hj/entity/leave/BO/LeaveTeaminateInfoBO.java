package com.hj.entity.leave.BO;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huangjie
 * @time 2019-06-20 14:06
 */
@Data
public class LeaveTeaminateInfoBO implements Serializable {
    private static final long serialVersionUID = -4419043701935253310L;
    /**
     * 销假开始时间
     */
    private String leaveTeaminateBeginTime;

    /**
     * 销假结束时间
     */
    private String leaveTeaminateEndTime;

    /**
     * 销假操作人姓名
     */
    private String leaveTeaminateOperateUserName;

    /**
     * 销假操作时间
     */
    private String leaveTeaminateOperateTime;

    /**
     * 销假原因
     */
    private String leaveTeaminateReason;
}
