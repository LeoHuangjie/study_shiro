package com.hj.util.NullObject;

/**
 * @author huangjie
 * @time 2019-05-16 15:50
 */
public class Client {
    public void test (DependenceBase dependenceBase){
        Factory.get(dependenceBase).operation();
    }
}
