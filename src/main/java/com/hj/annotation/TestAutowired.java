package com.hj.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author huangjie
 * @time 2019-06-06 15:40
 */
public class TestAutowired {
    /**
     * required = false 代表容器中没有当前bean时不抛异常
     */
    @Autowired (required = false)
    @Qualifier ("studentHomework1")
    private StudentHomework studentHomework;
}
