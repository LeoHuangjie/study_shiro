package com.hj.util.NullObject;

/**
 * @author huangjie
 * @time 2019-05-16 15:46
 */
public class Dependency implements DependenceBase {
    @Override
    public void operation() {
        System.out.println("test!");
    }

    @Override
    public boolean isNull() {
        return false;
    }
}
