package com.hj.util.intercept;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author huangjie
 * @time 2019-05-24 16:03
 */
@Component
@Slf4j
public class WebMvcConfig implements WebMvcConfigurer {
    @Resource
    private RequestLimitIntercept requestLimitIntercept;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("---Interceptor--requestLimit");
        registry.addInterceptor(requestLimitIntercept);
    }
}
