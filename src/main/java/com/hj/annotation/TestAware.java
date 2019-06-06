package com.hj.annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author huangjie
 * @time 2019-06-06 15:55
 */
@Component
public class TestAware implements ApplicationContextAware, BeanNameAware {

    private ApplicationContext applicationContext;

    @Override
    public void setBeanName(String s) {
        System.out.println("TestAware.........setBeanName....name:"+s);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
