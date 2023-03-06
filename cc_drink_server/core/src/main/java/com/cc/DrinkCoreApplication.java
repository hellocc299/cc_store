package com.cc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Author CC
 * @Date 2022/11/14
 */

@EnableJpaAuditing
@SpringBootApplication
public class DrinkCoreApplication {
    public static void main( String[] args )
    {
        SpringApplication.run(DrinkCoreApplication.class);
    }
}
