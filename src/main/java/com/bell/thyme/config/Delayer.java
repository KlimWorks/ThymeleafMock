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

    @Override
    public void run() {

        while(Delayer.currentThread().isAlive())   {

            init();

            //нельзя ставить Thread.sleep внутрь цикла! Но Thread.wait - подойдет
           frequencyDelayed();
        }
    }

    public void frequencyDelayed() {
        //надо вызывать метод wait из синхронизированного блока
        synchronized (Thread.currentThread()) {
            try {
                Thread.currentThread().wait(frequency);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @PostConstruct
    public static long getActualDelay(){
        return actualDelay;
    }
}
