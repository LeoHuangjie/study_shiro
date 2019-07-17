package com.hj.leave.service.base;

import com.hj.entity.leave.BO.LeaveTeaminateInfoBO;
import org.springframework.stereotype.Service;

/**
 * @author huangjie
 * @time 2019-06-21 18:13
 */
@Service
public class LeaveTeaminateService {

    public LeaveTeaminateInfoBO get () {
        return new LeaveTeaminateInfoBO();
    }
}
