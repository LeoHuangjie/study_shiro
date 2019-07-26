package com.hj.controller;

import java.lang.Runtime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

import com.google.common.collect.Lists;
import com.hj.excel.ExcelBody;
import com.hj.excel.ExcelEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangjie
 * @time 2019-07-19 14:42
 */
@RestController
@RequestMapping("/thread")
@Slf4j
public class ComputAndExportController {

    private int max = Math.max(Runtime.getRuntime().availableProcessors()-1,1);

    private BlockingQueue<Map<Integer, ExcelBody>> QUEUE = new ArrayBlockingQueue<>(max);

    @RequestMapping("compute")
    public void test () {
        ExecutorService executorService = Executors.newFixedThreadPool(max);

        List<Future> future = Lists.newArrayList();

        for (int i = 0; i<max; i++) {
            Future<ExcelBody> submit = executorService.submit(new Callable<ExcelBody>() {
                @Override
                public ExcelBody call() throws Exception {
                    return computeExportBody();
                }
            });
            future.add(submit);
        }
    }


    protected ExcelBody computeExportBody () {

        return null;
    }

}
