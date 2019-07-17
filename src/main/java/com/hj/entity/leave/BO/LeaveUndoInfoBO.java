package com.hj.entity.leave.BO;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huangjie
 * @time 2019-06-20 14:04
 */
@Data
public class LeaveUndoInfoBO implements Serializable {
    /**
     * 撤销原因
     */
    private String leaveUndoReason;

    /**
     * 撤销操作人
     */
    private String leaveUndoOperateUserName;

    /**
     * 撤销时间
     */
    private String leaveUndoOperateTime;
}
