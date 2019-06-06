package com.hj.annotation;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author huangjie
 * @time 2019-06-06 14:28
 */
public class TestCondition implements InitializingBean, DisposableBean {

    public TestCondition() {
        System.out.println("testestestet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("TestCondition--------destory");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("TestCondition-----afterPropertiesSet");
    }

    public void init () {
        System.out.println("TestCondition------init");
    }
}
