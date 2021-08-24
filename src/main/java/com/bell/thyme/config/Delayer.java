package com.bell.thyme.config;

import org.springframework.beans.factory.annotation.Value;

public class Delayer {

    @Value("${mock.firstDelay}")
    private long delay;

    @Value("${mock.firstFrequency}")
    private long frequency;

    public long getDelay(){
        return delay;
    }
//    public static void setActualDelay(long anyDelay) {
//        delay = anyDelay;
//    }

}
