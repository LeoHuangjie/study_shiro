package com.hj.leave.service.base;

import com.hj.entity.leave.BO.LeaveTeacherInfoBO;
import org.springframework.stereotype.Service;

/**
 * @author huangjie
 * @time 2019-06-21 18:01
 */
@Service
public class LeaveTeacherService {

    public LeaveTeacherInfoBO get (){
        return new LeaveTeacherInfoBO();
    }
}
