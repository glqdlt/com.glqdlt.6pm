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
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.time.ZoneId;
import java.util.Locale;
import java.util.TimeZone;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localeResolver(){
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setDefaultLocale(Locale.KOREAN);
        localeResolver.setCookieName("pm6Locale");
        localeResolver.setDefaultTimeZone(TimeZone.getTimeZone(ZoneId.of("Asia/Seoul")));
        return localeResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor a = new LocaleChangeInterceptor();
        a.setParamName("locale");
        registry.addInterceptor(a);
    }
}
