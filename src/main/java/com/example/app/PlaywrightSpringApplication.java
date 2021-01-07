package com.example.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlaywrightSpringApplication implements CommandLineRunner {


    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(PlaywrightSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        PageScreenshot pageScreenshot = new PageScreenshot();
        pageScreenshot.fetch();
    }
}
