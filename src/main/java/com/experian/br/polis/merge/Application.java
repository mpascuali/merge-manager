package com.experian.br.polis.merge;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.experian.br.polis.merge"})
@EnableRabbit
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}