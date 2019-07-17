package com.hj.leave.service.base;

import com.hj.entity.leave.BO.LeaveUndoInfoBO;
import org.springframework.stereotype.Service;

/**
 * @author huangjie
 * @time 2019-06-21 18:14
 */
@Service
public class LeaveUndoService {

    public LeaveUndoInfoBO get () {
        return new LeaveUndoInfoBO();
    }
}
