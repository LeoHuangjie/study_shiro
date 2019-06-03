package com.hj.util.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 *  解析监听器，
 *  每解析一行会回调invoke()方法。
 *  整个excel解析结束会执行doAfterAllAnalysed()方法
 *
 * @author huangjie
 * @time 2019-05-30 09:36
 */
@Slf4j
public class ExcelListener extends AnalysisEventListener {

    /**
     * 用于暂时存储data
     */
    private List<Object> data = Lists.newArrayList();

    @Override
    public void invoke(Object object, AnalysisContext analysisContext) {
        log.info("当前行：" + analysisContext.getCurrentSheet());
        log.info("当前行对象：" + JSON.toJSONString(object));
        data.add(object);
        if(data.size()>=100){
            doSomething();
            data = Lists.newArrayList();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //解析结束销毁不用的资源
        data.clear();
    }



    /**
     * 入库调用接口
     */
    public void doSomething(){
        // TODO: 2019-05-30 待修改
        for (Object o:data) {
            System.out.println(o);
        }
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
}
