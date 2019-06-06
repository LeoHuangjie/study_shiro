package com.hj.annotation;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author huangjie
 * @time 2019-06-06 14:56
 */
public class AixuexiBeanfactory implements FactoryBean<StudentHomework> {

    /**
     *     返回bean的对象
     */
    @Override
    public StudentHomework getObject() throws Exception {
        return new StudentHomework();
    }

    /**
     * 返回bean的类型
     * @return
     */
    @Override
    public java.lang.Class<?> getObjectType() {
        return StudentHomework.class;
    }

    /**
     * 是否为单例
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
