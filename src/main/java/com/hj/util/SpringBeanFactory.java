package com.hj.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author huangjie
 * @time 2019-06-10 19:30
 */
@Component
public class SpringBeanFactory implements ApplicationContextAware {

    private static ApplicationContext application;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        application = applicationContext;
    }

    public static <T> T getBean (Class<T> c) {
        T bean = application.getBean(c);
        return bean;
    }
}
