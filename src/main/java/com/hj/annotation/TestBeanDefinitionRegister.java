package com.hj.annotation;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author huangjie
 * @time 2019-06-06 14:50
 */
public class TestBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Homework.class);

        beanDefinitionRegistry.registerBeanDefinition("homework", rootBeanDefinition);
    }
}
