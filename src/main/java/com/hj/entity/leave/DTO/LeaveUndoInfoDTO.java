package com.hj.entity.leave.DTO;

import com.hj.entity.leave.BO.LeaveAuditInfoBO;
import com.hj.entity.leave.BO.LeaveInfoBO;
import lombok.Data;

import java.io.Serializable;

/**
 * @author huangjie
 * @time 2019-06-20 14:58
 */
@Data
public class LeaveUndoInfoDTO implements Serializable {
    private LeaveInfoBO leaveInfo;

    private LeaveAuditInfoBO leaveAuditInfo;

}
