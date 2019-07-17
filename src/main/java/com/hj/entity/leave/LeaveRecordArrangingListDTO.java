package com.hj.entity.leave;

import com.hj.entity.leave.DTO.LeaveListBaseDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huangjie
 * @time 2019-06-19 14:59
 * 排课-请假记录
 */
@Data
@Deprecated
public class LeaveRecordArrangingListDTO extends LeaveListBaseDTO implements Serializable {
    private static final long serialVersionUID = 3403209340767810277L;
    /**
     * 请假开始时间
     */
    private String leaveBeginTime;


}
