package com.hj.common;

import com.hj.service.InnerCommon;
import org.springframework.stereotype.Service;

/**
 * @author huangjie
 * @time 2019-06-10 19:24
 */
@Service
public class One implements InnerCommon {
    @Override
    public void process(Integer id) {
        System.out.println("11111111111");
    }
}
