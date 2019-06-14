package com.hj.service;

import com.hj.common.One;
import com.hj.enums.SystemEnumsGlobal;
import com.hj.util.SpringBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author huangjie
 * @time 2019-06-10 19:25
 */
@Component
public class InnerCommonContext {
    public InnerCommon getInstance (Integer id) throws ClassNotFoundException {
        Map<Integer, String> allClazz = SystemEnumsGlobal.getAllClazz();

        String s = allClazz.get(id);

        if (StringUtils.isEmpty(s)) {
            s = One.class.getName();
        }

        InnerCommon bean = (InnerCommon) SpringBeanFactory.getBean(Class.forName(s));
        return bean;
    }
}
