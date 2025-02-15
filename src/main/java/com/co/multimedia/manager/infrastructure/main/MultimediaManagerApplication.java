package com.co.multimedia.manager.infrastructure.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        "com.co.multimedia.manager"
})
@EntityScan(basePackages = {
        "com.co.multimedia.manager.crosscutting.domain.entity"
})
@EnableJpaRepositories(basePackages = {
        "com.co.multimedia.manager.crosscutting.domain.repository"
})
public class MultimediaManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultimediaManagerApplication.class, args);
    }

}
