package com.example.demo;

import com.example.demo.ActiveMQ.Consummer;
import com.example.demo.ActiveMQ.Producer;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Hao on 2018/3/16.
 */

@RunWith(SpringRunner.class)
//@ImportResource(locations = "classpath:spring-mvc.xml")
@SpringBootTest
public class TestActiveMQ {

    @Autowired
    private Consummer consummer;

    @Autowired
    private Producer producer;

    @Autowired
    private Destination destination;

    @Test
    public void testActiveMQ(){

        ExecutorService
                executorService = new ThreadPoolExecutor(10,50,0L, TimeUnit.MICROSECONDS,
                new LinkedBlockingQueue<Runnable>(1024),
                new ThreadFactoryBuilder().setNameFormat("index-thread-%d").build(),
                new ThreadPoolExecutor.AbortPolicy());

        for(int i =0 ;i<10;i++){
            System.out.println("{} the "+i+"th producer");
            executorService.submit(new RunningProducer());
        }
        for (int j= 0;j<10;j++) {
            System.out.println("{} the "+j+"th consumer");
            executorService.submit(new RunningConsummer());
        }

    }

    class RunningConsummer implements Runnable {

        @Override
        public void run() {
            consummer.receive(destination);
        }
    }

    class RunningProducer implements  Runnable{

        @Override
        public void run() {
            producer.sendMessage("Hello ACtiveMQ");

        }
    }
    @Test
    public void producer(){
      producer.sendMessage("Hello ActiveMQ producer");
    }

    @Test
    public void consummer(){
        consummer.receive(destination);
    }

}