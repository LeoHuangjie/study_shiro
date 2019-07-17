package com.hj.entity.leave.DTO;

import com.hj.entity.leave.BO.LeaveStudentInfoBO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author huangjie
 * @time 2019-06-21 13:50
 * 批量审核弹窗
 */
@Data
public class LeaveBatchReviewDTO implements Serializable {

    private static final long serialVersionUID = 2672039589141099192L;

    private List<LeaveAllInfoDTO> leaveAllInfoS;

    private List<LeaveStudentInfoBO> leaveStudentInfos;

}
