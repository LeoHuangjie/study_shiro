package com.hj.util.NullObject;

/**
 * @author huangjie
 * @time 2019-05-16 15:48
 */
public class Factory {
    public static DependenceBase get (Object dependenceBase) {
        if (dependenceBase == null) {
            return new NullObject();
        }

        return new Dependency();
    }
}
