package com.glqdlt.pm6.webcms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Date 2019-11-30
 *
 * @author glqdlt
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${image.location}")
    public String location;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**")
                .addResourceLocations(platformImagePathMaker());
    }

    /**
     * @return resourceLocations 에 들어갈 경로 String 을 반환함.
     *
     * os 가 윈도우일 때 다르게 적용해야기 때문.
     * exam)
     * window 일 때.. file:///
     * linux 등 일 때.. file:/
     * @see <a href='https://www.baeldung.com/spring-mvc-static-resources'>https://www.baeldung.com/spring-mvc-static-resources</a>
     */
    private String platformImagePathMaker() {
        String platformName = System.getProperty("os.name");
        String path = location;
        if (!this.location.startsWith("/")) {
            path = "/" + path;
        }
        if (platformName.toLowerCase().startsWith("win")) {
            return "file://" + path;
        } else {
            return "file:" + path;
        }
    }
}
