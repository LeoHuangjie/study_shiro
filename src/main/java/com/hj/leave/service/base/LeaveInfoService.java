package com.hj.leave.service.base;

import com.hj.entity.leave.BO.LeaveInfoBO;
import org.springframework.stereotype.Service;

/**
 * @author huangjie
 * @time 2019-06-21 18:12
 */
@Service
public class LeaveInfoService {

    public LeaveInfoBO get () {
        return new LeaveInfoBO();
    }
}
