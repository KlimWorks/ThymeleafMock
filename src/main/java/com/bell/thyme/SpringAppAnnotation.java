package com.bell.thyme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SpringAppAnnotation {

    public static void startApp(){
        SpringApplication.run(SpringAppAnnotation.class);
    }
}
