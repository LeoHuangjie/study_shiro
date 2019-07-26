package com.hj.express;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author huangjie
 * @time 2019-07-25 09:49
 */
public class HutoolUtil {

    public static <T> void exportExcel (List<T> list, Map<String, String> map, String title) throws IOException {
//        httpServletResponse.setHeader("Content-Disposition", "attachment;fileName=" + new String((new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".xlsx").getBytes("UTF-8")));

        ExcelWriter writer = ExcelUtil.getWriter(true);

        Set<Map.Entry<String, String>> entries = map.entrySet();

        Iterator<Map.Entry<String, String>> iterator = entries.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            writer.addHeaderAlias(next.getKey(), next.getValue());
        }

//        writer.merge(map.size() - 1, title);

        writer.write(list);

        writer.flush(new FileOutputStream("/Users/huangjie/workspace/"+title+".xlsx"));

        writer.close();
    }

    public static void exportExcel (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    List<Map<String,Object>> list, String title) throws IOException {
        httpServletResponse.setHeader("Content-Disposition", "attachment;fileName=" + new String((new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".xlsx").getBytes("UTF-8")));

        ExcelWriter writer = ExcelUtil.getWriter(true);

        writer.merge(list.size()-1, title);

        writer.write(list);

        writer.flush(httpServletResponse.getOutputStream());

        writer.close();
    }

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<List<UserbuyRelation>> BUFFER = new ArrayBlockingQueue<List<UserbuyRelation>>(7);
        List<UserbuyRelation> userbuyRelations1 = new ArrayList<>();
        for (int i =1;i<=13;i++) {
            // TODO: 2019-07-25 查询已确认地址的 分页查询每页10000个 正序
            List<UserbuyRelation> userbuyRelations = assemblyEntiy();
            if (CollectionUtils.isEmpty(userbuyRelations)) {
                break;
            }
            //获取最后一个ID
//            nextId = userbuyRelations.get(userbuyRelations.size() - 1).getId();

            userbuyRelations1.add(userbuyRelations.get(i-1));
            if (i%3 == 0) {
                BUFFER.put(userbuyRelations1);
                userbuyRelations1.clear();
            }

            if (i==13) {
                List<UserbuyRelation> userbuyRelations13 = new ArrayList<>();
                userbuyRelations13.add(userbuyRelations.get(i-1));
                BUFFER.put(userbuyRelations13);

            }

        }

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
