package com.hj.entity.leave.BO;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huangjie
 * @time 2019-06-20 13:59
 */
@Data
public class LeaveAuditInfoBO implements Serializable {
    /**
     * 审核状态(0:待审核，1：审核通过，2：已驳回，3：已撤销，4：已销假)
     */
    private Integer auditStatus;

    /**
     * 审核备注
     */
    private String auditRemark;

    /**
     * 审核人
     */
    private String auditUserName;

    /**
     * 审核时间
     */
    private String auditTime;
}
