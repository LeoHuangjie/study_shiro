package com.hj.entity.leave;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huangjie
 * @time 2019-06-19 14:29
 */
@Data
public class Leave implements Serializable {

    private static final long serialVersionUID = -6676786439253089374L;
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 请假人姓名
     */
    private String teacherUserName;

    /**
     * 请假审核状态 (0:待审核，1：审核通过，2：已驳回，3：已撤销)
     */
    private Integer leaveStatus;

    /**
     * 申请时间
     */
    private Date applyForTime;

    /**
     * 申请人姓名
     */
    private String creatorName;

    /**
     * 申请人id
     */
    private Integer creatorUserId;

    /**
     * 审核时间
     */
    private Date auditTime;

    /**
     * 审核人id
     */
    private Integer auditUserId;

    /**
     * 审核人姓名
     */
    private String auditUserName;

    /**
     * 请假来源 (0:日程表，1：师资管理后台)
     */
    private Integer source;

    /**
     * 是否删除
     */
    private Integer delete;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后操作人
     */
    private String operator;

}
