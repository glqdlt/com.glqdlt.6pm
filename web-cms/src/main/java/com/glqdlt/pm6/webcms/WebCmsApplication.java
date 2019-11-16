package com.glqdlt.pm6.webcms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.glqdlt.pm6.*")
public class WebCmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebCmsApplication.class, args);
    }

}
