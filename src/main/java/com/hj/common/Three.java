package com.hj.common;

import com.hj.service.InnerCommon;
import org.springframework.stereotype.Service;

/**
 * @author huangjie
 * @time 2019-06-10 19:25
 */
@Service
public class Three implements InnerCommon {
    @Override
    public void process(Integer id) {
        System.out.println("33333333");
    }
}
