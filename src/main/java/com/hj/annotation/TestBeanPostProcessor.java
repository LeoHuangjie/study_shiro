package com.hj.annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author huangjie
 * @time 2019-06-06 15:28
 *
 * 在bean初始化前后可以做事情
 *
 */
public class TestBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("TestBeanPostProcessor........Before......beanName:"+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("TestBeanPostProcessor........After......beanName:"+beanName);
        return bean;
    }
}
