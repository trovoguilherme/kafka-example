package br.com.skeleton.consumer.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "br.com.skeleton.romote")
@SpringBootApplication
public class ConsumerAsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerAsyncApplication.class, args);
    }

}
