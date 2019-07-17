package com.hj.leave.service.base;

import com.hj.entity.leave.BO.LeaveAuditInfoBO;
import org.springframework.stereotype.Service;

/**
 * @author huangjie
 * @time 2019-06-21 18:10
 */
@Service
public class LeaveAuditService {

    public LeaveAuditInfoBO get () {
        return new LeaveAuditInfoBO();
    }
}
