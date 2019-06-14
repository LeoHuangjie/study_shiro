package com.hj.annotation;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * @author huangjie
 * @time 2019-06-06 11:40
 */
@Configuration
@ComponentScan(basePackages = {"com.hj.annotation"}, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class})})
//@ComponentScan(basePackages = {"com.hj.annotation"}, includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class})})
//@ComponentScan(basePackages = {"com.hj.annotation"}, includeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, value = {CustomFilterType.class})})
@Import(value = {ComponentScanTest.class,TestBeanDefinitionRegister.class})
public class MainConfig {

    @Bean
    @Lazy
//    @Scope(scopeName = "prototype")
    public Student student () {
       return new Student();
    }

    @Bean
    public Lesson lesson () {
        return new Lesson();
    }

    @Bean
//    @Bean (initMethod = "init", destroyMethod = "destory")
//    @Conditional(value = ConditionTest.class)
    public TestCondition testCondition () {
        return new TestCondition();
    }

    @Bean
    @Conditional(value = ConditionTest.class)
    public TestCondition1 testCondition1 () {
        return new TestCondition1();
    }

    @Bean
    public AixuexiBeanfactory aixuexiBeanfactory () {
        return new AixuexiBeanfactory();
    }


    @Bean
    public JSR250Test jsr250Test () {
        return new JSR250Test();
    }


    @Bean
    public TestBeanPostProcessor testBeanPostProcessor () {
        return new TestBeanPostProcessor();
    }

//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
//
//        Student student = (Student) annotationConfigApplicationContext.getBean("student");
//        System.out.println(student);
////        Student student1 = (Student) annotationConfigApplicationContext.getBean("student");
////        System.out.println(student1);
////        boolean equals = student == student1;
////        System.out.println(equals);
//
//        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
//
//        for (int i = 0; i<beanDefinitionNames.length; i++) {
//            System.out.println(beanDefinitionNames[i]);
//        }
//
//
//        Object aixuexiBeanfactory = annotationConfigApplicationContext.getBean("aixuexiBeanfactory");
//        System.out.println(aixuexiBeanfactory);
//        Object bean = annotationConfigApplicationContext.getBean("&aixuexiBeanfactory");
//        System.out.println(bean);
//
//
//        annotationConfigApplicationContext.close();
//
//    }
}
