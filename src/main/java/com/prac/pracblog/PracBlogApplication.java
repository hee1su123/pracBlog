package com.prac.pracblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PracBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracBlogApplication.class, args);
    }

}
