package com.hj.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author huangjie
 * @time 2019-06-06 15:22
 */
public class JSR250Test {

    public JSR250Test () {
        System.out.println("JSR250Test.....");
    }


    @PostConstruct
    public void init () {
        System.out.println("JSR250Test........init");
    }


    @PreDestroy
    public void destroy () {
        System.out.println("JSR250Test.........destroy");
    }
}
