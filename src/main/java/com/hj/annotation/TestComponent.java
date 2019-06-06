package com.hj.annotation;

import org.springframework.stereotype.Component;

/**
 * @author huangjie
 * @time 2019-06-06 15:47
 * Component 与 ComponentScan 一起使用
 *
 */
@Component
public class TestComponent {

    public TestComponent () {
        System.out.println("TestComponent.........");
    }
}
