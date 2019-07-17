package com.hj.leave.service.base;

import com.hj.entity.leave.BO.LeaveStudentInfoBO;
import org.springframework.stereotype.Service;

/**
 * @author huangjie
 * @time 2019-06-21 18:12
 */
@Service
public class LeaveStudentService {

    public LeaveStudentInfoBO get () {
        return new LeaveStudentInfoBO();
    }
}
