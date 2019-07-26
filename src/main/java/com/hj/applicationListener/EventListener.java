package com.hj.applicationListener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author huangjie
 * @time 2019-07-22 11:32
 */
//@Component
public class EventListener implements ApplicationListener {

//    @Async
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("test----async!!!!"+applicationEvent.getSource());
    }
}
