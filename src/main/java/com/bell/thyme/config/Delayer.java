package com.bell.thyme.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Delayer extends Thread {

    @Value("${mock.firstDelay}")
    public long delayFromProperties;

    @Value("${mock.firstFrequency}")
    private long frequency;

    public static long actualDelay;

    @PostConstruct
    public void init(){
        actualDelay = delayFromProperties;
    }

//    @Override
//    public void run() {
//            while(true)   {
//
//            init();
//
//            try {
//                Thread.sleep(frequency);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public static long getActualDelay(){
        return actualDelay;
    }


}
