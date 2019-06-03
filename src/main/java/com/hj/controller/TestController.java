package com.hj.controller;


import com.alibaba.fastjson.JSON;
import com.hj.entity.Test;
import com.hj.entity.enums.ResultCode;
import com.hj.entity.excel.model.ExcelReadUser;
import com.hj.entity.excel.model.ExcelWriteUser;
import com.hj.entity.resultData.ResultData;
import com.hj.service.TestService;
import com.hj.util.NullObject.DependenceBase;
import com.hj.util.NullObject.Factory;
import com.hj.util.annotation.RequestLimit;
import com.hj.util.excel.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.hj.util.excel.DataUtil.*;

/**
 * @author huangjie
 * @time 2019-05-13 19:13
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Resource
    private TestService testService;

    @RequestMapping("index")
    @RequestLimit(second = 10, maxCount = 5)
    public ResultData<Test> test (Integer id) {
        log.info("---------params:{}",id);
        DependenceBase dependenceBase = Factory.get(id);
        if (dependenceBase.isNull()) {
            return ResultData.fail(ResultCode.PARAMS_NULL);
        }
        return ResultData.success(testService.selectOne(id));
    }

    @RequestMapping("index1")
    @RequestLimit(second = 10)
    public ResultData<Test> test1 (Integer id) {
        log.info("---------params:{}",id);
        DependenceBase dependenceBase = Factory.get(id);
        if (dependenceBase.isNull()) {
            return ResultData.fail(ResultCode.PARAMS_NULL);
        }
        return ResultData.success(testService.selectOne(id));
    }

    @RequestMapping("readExcel")
    public void readExcel (String path,HttpServletResponse response) throws IOException {
        log.info("---------begin");
//        List<Object> objects = ExcelUtil.simpleReadListStringV2007(path);
//        List<Object> objects = ExcelUtil.simpleReadJavaModelV2007(path, ExcelReadUser.class);
//        log.info("ExcelData:{}",JSON.toJSONString(objects));
//        ExcelUtil.saxReadListStringV2007(path);
//        ExcelUtil.saxReadJavaModelV2007(path, ExcelReadUser.class);
        String fileName = "test";
        List<List<Object>> testListObject = createTestListObject();
        List<List<String>> testListStringHead = createTestListStringHead();
        List<ExcelWriteUser> testListJavaMode = createTestListJavaMode();
//        ExcelUtil.writeV2007WithAnnotation(response, ExcelWriteUser.class,  fileName, testListJavaMode);

        ExcelUtil.writeV2007WithTable(response, fileName, testListStringHead, testListObject);
//        for (Object o : objects) {
//            System.out.println(o);
//        }
    }
}
