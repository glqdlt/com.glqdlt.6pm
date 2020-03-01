package com.glqdlt.pm6.webcms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.glqdlt.pm6.*",
        exclude = {SecurityAutoConfiguration.class})
public class WebCmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebCmsApplication.class, args);
    }

}
