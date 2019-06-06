package com.hj.annotation;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author huangjie
 * @time 2019-06-06 14:29
 */
public class ConditionTest implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        if(conditionContext.getBeanFactory().containsBean("testCondition")) {
            return true;
        }

        return false;
    }
}
