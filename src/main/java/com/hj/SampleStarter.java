package com.hj;

import com.alibaba.fastjson.JSON;
import com.battcn.boot.request.annotation.EnableI18n;
import com.hj.mapstructTest.EntryMapping;
import com.hj.mapstructTest.Student;
import com.hj.mapstructTest.StudentDto;
import com.hj.service.impl.CelueMoshi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

@SpringBootApplication
@EnableTransactionManagement
@EnableI18n
//@ImportResource()//config springxml
public class SampleStarter {

    private Logger logger = LoggerFactory.getLogger(getClass());


    public static void main(String[] args) {
        final ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(SampleStarter.class, args);

        SampleStarter bean = configurableApplicationContext.getBean(SampleStarter.class);
        bean.logger.info("---------------info");

        CelueMoshi bean1 = configurableApplicationContext.getBean(CelueMoshi.class);

        bean1.test(1);

        bean1.test18In();


        Student student = new Student();
        student.setId(1);
        student.setName("123");
        student.setAge(1);
        student.setBeginTime(new Date());
        student.setEndTime(new Date());
        student.setClassId(1);
        student.setLessonId(1);
        student.setSex(1);
        StudentDto to = EntryMapping.ENTRY_MAPPER.to(student);

        Student from = EntryMapping.ENTRY_MAPPER.from(to);

        System.out.println(JSON.toJSONString(to));

        System.out.println(JSON.toJSONString(from));

        blockMainWithSocket(configurableApplicationContext);


    }



    private static void blockMainWithSocket(ConfigurableApplicationContext context){
        try(ServerSocket serverSocket = new ServerSocket()){
            serverSocket.bind(new InetSocketAddress("localhost",36215));
            //just block and close
            try (Socket s  = serverSocket.accept()){}
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}