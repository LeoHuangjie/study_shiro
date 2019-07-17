package com.hj.entity.leave.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huangjie
 * @time 2019-06-21 15:43
 */
@Data
public class OperationLogDTO implements Serializable {

    private static final long serialVersionUID = -1772281185621130161L;
    /**
     * 操作日志ID
     */
    private Integer operationLogId;

    /**
     * 操作人ID
     */
    private Integer operatorId;

    /**
     * 操作人姓名
     */
    private String operatorName;

    /**
     * 操作类型 (0:删除，1：增加，2：修改)
     */
    private Integer operateType;

    /**
     * 操作原因
     */
    private String operateReason;

    /**
     * 操作内容
     */
    private String operateDescription;
}
