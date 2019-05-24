package com.hj.controller;


import com.hj.entity.Test;
import com.hj.entity.enums.ResultCode;
import com.hj.entity.resultData.ResultData;
import com.hj.service.TestService;
import com.hj.util.NullObject.DependenceBase;
import com.hj.util.NullObject.Factory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author huangjie
 * @time 2019-05-13 19:13
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestService testService;

    @RequestMapping("index")
    public ResultData<Test> test (Integer id) {
        DependenceBase dependenceBase = Factory.get(id);
        if (dependenceBase.isNull()) {
            return ResultData.fail(ResultCode.PARAMS_NULL);
        }
        return ResultData.success(testService.selectOne(id));
    }
}
