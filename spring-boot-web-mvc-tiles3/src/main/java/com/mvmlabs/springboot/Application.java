package com.mvmlabs.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Spring Source Tool Suite.
 * 
 * @author Mark Meany
 */
@Configuration
@ComponentScan(nameGenerator = FullBeanNameGenerator.class)
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
