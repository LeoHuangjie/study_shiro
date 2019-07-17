package com.hj.util;

/**
 * @author huangjie
 * @time 2019-06-17 14:08
 */
public class IdentityHashCodeTest {

    /**
     * hashCode方法可以被重写并返回重写后的值，
     * identityHashCode会返回对象的hash值而不管对象是否重写了hashCode方法。
     *
     *
     *
     * 因为String类重写了hashCode方法，它根据String的值来确定hashCode的值，所以只要值一样，hashCode就会一样。
     *
     * str1和str2的identityHashCode不一样，虽然String重写了hashCode方法，
     * identityHashCode永远返回根据对象物理内存地址产生的hash值，
     * 所以每个String对象的物理地址不一样，identityHashCode也会不一样。
     *
     */
    public static void test () {
        String abc1 = new String("abc");
        String abc2 = new String("abc");
        System.out.println(abc1.hashCode());
        System.out.println(abc2.hashCode());
        System.out.println(System.identityHashCode(abc1));
        System.out.println(System.identityHashCode(abc2));
    }


    public static void main(String[] args) {
        test();
    }
}
