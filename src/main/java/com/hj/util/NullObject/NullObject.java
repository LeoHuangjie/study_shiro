package com.hj.util.NullObject;

/**
 * @author huangjie
 * @time 2019-05-16 15:47
 */
public class NullObject implements DependenceBase {
    @Override
    public void operation() {
        System.out.println("输入为空，请重新输入");
    }

    @Override
    public boolean isNull() {
        return true;
    }
}
