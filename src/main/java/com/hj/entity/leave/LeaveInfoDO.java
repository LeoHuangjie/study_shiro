package com.hj.entity.leave;

import lombok.Data;

import java.util.Date;

/**
 * @author huangjie
 * @time 2019-06-25 16:19
 */
@Data
public class LeaveInfoDO {
    /**
     * 教师用户名
     */
    private String teacherUserName;

    /**
     * 教师ID
     */
    private Integer teacherId;

    /**
     * 申请时间
     */
    private Date applyForTime;

    /**
     * 申请人用户名
     */
    private String creatorName;

    /**
     * 申请人ID
     */
    private Integer creatorUserId;

    /**
     * 数据来源
     */
    private Integer source;



}
