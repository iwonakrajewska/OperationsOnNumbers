package com.iwona.operationsonnumbers.executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.iwona.operationsonnumbers.config.AppInitializer;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.iwona"})
public class Application {

    public static void main(final String[] args) {
        SpringApplication.run(new Class[] {Application.class, AppInitializer.class}, args);
    }

}
