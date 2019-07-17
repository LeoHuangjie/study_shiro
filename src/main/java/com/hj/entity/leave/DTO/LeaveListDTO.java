package com.hj.entity.leave.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huangjie
 * @time 2019-06-19 14:44
 * 请假管理列表
 */
@Data
public class LeaveListDTO extends LeaveListBaseDTO implements Serializable {

    private static final long serialVersionUID = 426101536371523637L;


    /**
     * 请假人用户名
     */
    private String teacherUserName;

    /**
     * 请假人真实姓名
     */
    private String teacherRealName;

}
