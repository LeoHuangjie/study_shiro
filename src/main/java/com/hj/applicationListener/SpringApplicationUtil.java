package com.hj.applicationListener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * @author huangjie
 * @time 2019-07-22 11:28
 */
//@Component
//@EnableAsync
public class SpringApplicationUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringApplicationUtil.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public <T>  T  getBean(String name) {

        return (T) applicationContext.getBean(name);

    }


    public void pustEvent (ApplicationEvent applicationEvent) {
        applicationContext.publishEvent(applicationEvent);
    }
}
