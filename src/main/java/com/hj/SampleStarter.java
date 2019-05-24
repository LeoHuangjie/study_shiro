package com.hj;

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

@SpringBootApplication
@EnableTransactionManagement
//@ImportResource()//config springxml
public class SampleStarter {

    private Logger logger = LoggerFactory.getLogger(getClass());


    public static void main(String[] args) {
        final ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(SampleStarter.class, args);

        SampleStarter bean = configurableApplicationContext.getBean(SampleStarter.class);
        bean.logger.info("---------------info");

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