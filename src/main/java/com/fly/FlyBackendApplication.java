package com.fly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author david
 * @date 31/07/18 18:27
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class FlyBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlyBackendApplication.class, args);
    }

}
