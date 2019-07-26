package com.hj.express;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huangjie
 * @time 2019-07-26 14:04
 */
@Slf4j
public class SyncExportExpress implements Runnable {

    private int coreNum = Math.max(Runtime.getRuntime().availableProcessors()-1,1);

    private BlockingQueue<List<UserbuyRelation>> BUFFER = new ArrayBlockingQueue<List<UserbuyRelation>>(coreNum);

    private AtomicBoolean atomicBoolean = new AtomicBoolean(Boolean.FALSE);

    private Integer bookId;

    public SyncExportExpress(Integer bookId) {
        this.bookId = bookId;
    }

    @Override
    public void run() {

        try {
            startPool(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




    private void startPool (Integer bookId) throws InterruptedException {
        log.info("..........{}",bookId);
        AtomicInteger atomicNum = new AtomicInteger(0);
        ExecutorService executorService = Executors.newFixedThreadPool(coreNum);
        for (int i=0; i<coreNum;i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    filterBuffer(atomicNum);
                }
            });
        }

        Integer nextId = 0;

        //TODO: 2019-07-25 查询已确认地址的
//        for (int i =1;i<=4;i++) {
        // TODO: 2019-07-25 查询已确认地址的 分页查询每页10000个 正序
        List<UserbuyRelation> userbuyRelations = assemblyEntiy();

//            if (CollectionUtils.isEmpty(userbuyRelations)) {
//                break;
//            }
        //获取最后一个ID
//            nextId = userbuyRelations.get(userbuyRelations.size() - 1).getId();

        Thread.sleep(5000);

        List<UserbuyRelation> userbuyRelations1 = new ArrayList<>();
        userbuyRelations1.add(userbuyRelations.get(0));
        userbuyRelations1.add(userbuyRelations.get(1));
        userbuyRelations1.add(userbuyRelations.get(2));
        log.info("every put to queue ...."+JSON.toJSONString(userbuyRelations1));
        BUFFER.put(userbuyRelations1);

        Thread.sleep(500);

        List<UserbuyRelation> userbuyRelations2 = new ArrayList<>();
        userbuyRelations2.add(userbuyRelations.get(3));
        userbuyRelations2.add(userbuyRelations.get(4));
        userbuyRelations2.add(userbuyRelations.get(5));
        log.info("every put to queue ...."+JSON.toJSONString(userbuyRelations2));
        BUFFER.put(userbuyRelations2);

        Thread.sleep(500);

        List<UserbuyRelation> userbuyRelations3 = new ArrayList<>();
        userbuyRelations3.add(userbuyRelations.get(6));
        userbuyRelations3.add(userbuyRelations.get(7));
        userbuyRelations3.add(userbuyRelations.get(8));
        log.info("every put to queue ...."+JSON.toJSONString(userbuyRelations3));
        BUFFER.put(userbuyRelations3);

        Thread.sleep(500);

        List<UserbuyRelation> userbuyRelations4 = new ArrayList<>();
        userbuyRelations4.add(userbuyRelations.get(9));
        userbuyRelations4.add(userbuyRelations.get(10));
        userbuyRelations4.add(userbuyRelations.get(11));
        log.info("every put to queue ...."+JSON.toJSONString(userbuyRelations4));
        BUFFER.put(userbuyRelations4);
        Thread.sleep(500);

        log.info("every put to queue ....BUFFER.size:{}",BUFFER.size());
        log.info("put is not full....");
        List<UserbuyRelation> userbuyRelations13 = new ArrayList<>();
        userbuyRelations13.add(userbuyRelations.get(12));
        BUFFER.put(userbuyRelations13);
        log.info(".put is not full.....BUFFER.size:{}",BUFFER.size());


//        }

        atomicBoolean.set(Boolean.TRUE);

        while (BUFFER.size() != 0) {
            log.info("thread wait for sub");
            Thread.sleep(2000);
        }

        log.info("export finish !!!!!");

        executorService.shutdown();
    }




    private void filterBuffer (AtomicInteger atomicNum) {
        log.info("begin thread pool......");
        List<UserbuyRelation> userbuyRelations = new ArrayList<>(3);

        while (BUFFER.size() > 0 || !atomicBoolean.get() ) {
//            List<UserbuyRelation> subBuffer = null;
            log.info("........BUFFER is size {}",BUFFER.size());
//            try {
            try {
                userbuyRelations = BUFFER.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("taking .........{}", JSON.toJSONString(userbuyRelations));
//            } catch (InterruptedException e) {
//                log.info("stop sub thread. write lt file.");
//            }

            if (CollectionUtils.isEmpty(userbuyRelations)) {
                log.info("userbuyRelations is empty-----");
                continue;
            }

            if (userbuyRelations.size() == 3) {
                try {
                    log.info("export foreach excel!!!!!!!!,{}",JSON.toJSONString(userbuyRelations));
                    HutoolUtil.exportExcel(userbuyRelations, headName(),"express_makeSureAddress_"+atomicNum.incrementAndGet());
                    userbuyRelations.clear();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        if (!CollectionUtils.isEmpty(userbuyRelations)) {
            try {
                log.info("export last excel.......!!!!");
                HutoolUtil.exportExcel(userbuyRelations, headName(),"express_makeSureAddress_"+atomicNum.incrementAndGet());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    private static Map<String,String> headName () {
        Map<String, String > headName = Maps.newHashMap();
        headName.put("productId","产品线id");
        headName.put("productName","产品名称");
        headName.put("userId","用户id");
        headName.put("userName","用户名");
        headName.put("orderNo","订单号");
        headName.put("serviceId","服务id");
        headName.put("serviceCode","服务code");
        return headName;
    }


    private static List<UserbuyRelation> assemblyEntiy () {
        UserbuyRelation userbuyRelation1 = new UserbuyRelation();
        userbuyRelation1.setProductId(1);
        userbuyRelation1.setProductName("product1");
        userbuyRelation1.setUserId(1);
        userbuyRelation1.setUserName("11");
        userbuyRelation1.setOrderNo("asd11");
        userbuyRelation1.setServiceId(1);
        userbuyRelation1.setServiceCode("service11");

        UserbuyRelation userbuyRelation2 = new UserbuyRelation();
        userbuyRelation2.setProductId(2);
        userbuyRelation2.setProductName("product2");
        userbuyRelation2.setUserId(2);
        userbuyRelation2.setUserName("22");
        userbuyRelation2.setOrderNo("asd22");
        userbuyRelation2.setServiceId(2);
        userbuyRelation2.setServiceCode("service22");


        UserbuyRelation userbuyRelation3 = new UserbuyRelation();
        userbuyRelation3.setProductId(3);
        userbuyRelation3.setProductName("product3");
        userbuyRelation3.setUserId(3);
        userbuyRelation3.setUserName("33");
        userbuyRelation3.setOrderNo("asd33");
        userbuyRelation3.setServiceId(3);
        userbuyRelation3.setServiceCode("service33");


        UserbuyRelation userbuyRelation4 = new UserbuyRelation();
        userbuyRelation4.setProductId(4);
        userbuyRelation4.setProductName("product4");
        userbuyRelation4.setUserId(4);
        userbuyRelation4.setUserName("44");
        userbuyRelation4.setOrderNo("asd44");
        userbuyRelation4.setServiceId(4);
        userbuyRelation4.setServiceCode("service44");


        UserbuyRelation userbuyRelation5 = new UserbuyRelation();
        userbuyRelation5.setProductId(5);
        userbuyRelation5.setProductName("product5");
        userbuyRelation5.setUserId(5);
        userbuyRelation5.setUserName("55");
        userbuyRelation5.setOrderNo("asd55");
        userbuyRelation5.setServiceId(5);
        userbuyRelation5.setServiceCode("service55");


        UserbuyRelation userbuyRelation6 = new UserbuyRelation();
        userbuyRelation6.setProductId(6);
        userbuyRelation6.setProductName("product6");
        userbuyRelation6.setUserId(6);
        userbuyRelation6.setUserName("66");
        userbuyRelation6.setOrderNo("asd66");
        userbuyRelation6.setServiceId(6);
        userbuyRelation6.setServiceCode("service66");


        UserbuyRelation userbuyRelation7 = new UserbuyRelation();
        userbuyRelation7.setProductId(7);
        userbuyRelation7.setProductName("product7");
        userbuyRelation7.setUserId(7);
        userbuyRelation7.setUserName("77");
        userbuyRelation7.setOrderNo("asd77");
        userbuyRelation7.setServiceId(7);
        userbuyRelation7.setServiceCode("service77");

        UserbuyRelation userbuyRelation8 = new UserbuyRelation();
        userbuyRelation8.setProductId(8);
        userbuyRelation8.setProductName("product8");
        userbuyRelation8.setUserId(8);
        userbuyRelation8.setUserName("88");
        userbuyRelation8.setOrderNo("asd88");
        userbuyRelation8.setServiceId(8);
        userbuyRelation8.setServiceCode("service88");

        UserbuyRelation userbuyRelation9 = new UserbuyRelation();
        userbuyRelation9.setProductId(9);
        userbuyRelation9.setProductName("product9");
        userbuyRelation9.setUserId(9);
        userbuyRelation9.setUserName("99");
        userbuyRelation9.setOrderNo("asd99");
        userbuyRelation9.setServiceId(9);
        userbuyRelation9.setServiceCode("service99");

        UserbuyRelation userbuyRelation10 = new UserbuyRelation();
        userbuyRelation10.setProductId(10);
        userbuyRelation10.setProductName("product10");
        userbuyRelation10.setUserId(10);
        userbuyRelation10.setUserName("10");
        userbuyRelation10.setOrderNo("asd10");
        userbuyRelation10.setServiceId(10);
        userbuyRelation10.setServiceCode("service10");


        UserbuyRelation userbuyRelation11 = new UserbuyRelation();
        userbuyRelation11.setProductId(11);
        userbuyRelation11.setProductName("product11");
        userbuyRelation11.setUserId(11);
        userbuyRelation11.setUserName("1111");
        userbuyRelation11.setOrderNo("asd11");
        userbuyRelation11.setServiceId(11);
        userbuyRelation11.setServiceCode("service1111");


        UserbuyRelation userbuyRelation12 = new UserbuyRelation();
        userbuyRelation12.setProductId(12);
        userbuyRelation12.setProductName("product12");
        userbuyRelation12.setUserId(12);
        userbuyRelation12.setUserName("12");
        userbuyRelation12.setOrderNo("asd12");
        userbuyRelation12.setServiceId(12);
        userbuyRelation12.setServiceCode("service12");

        UserbuyRelation userbuyRelation13 = new UserbuyRelation();
        userbuyRelation13.setProductId(13);
        userbuyRelation13.setProductName("product13");
        userbuyRelation13.setUserId(13);
        userbuyRelation13.setUserName("13");
        userbuyRelation13.setOrderNo("asd13");
        userbuyRelation13.setServiceId(13);
        userbuyRelation13.setServiceCode("service13");

        List<UserbuyRelation> list = Lists.newArrayList();

        list.add(userbuyRelation1);
        list.add(userbuyRelation2);
        list.add(userbuyRelation3);
        list.add(userbuyRelation4);
        list.add(userbuyRelation5);
        list.add(userbuyRelation6);
        list.add(userbuyRelation7);
        list.add(userbuyRelation8);
        list.add(userbuyRelation9);
        list.add(userbuyRelation10);
        list.add(userbuyRelation11);
        list.add(userbuyRelation12);
        list.add(userbuyRelation13);

        return list;
    }
}
