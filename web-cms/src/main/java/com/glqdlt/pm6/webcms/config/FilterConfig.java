package com.glqdlt.pm6.webcms.config;

import com.glqdlt.pm6.webcms.web.controller.view.filter.NotSupportedIEFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.glqdlt.pm6.webcms.web.controller.view.ErrorController.NOT_SUPPORTED_IE_PATH;


/**
 * Date 2019-08-10
 *
 * @author glqdlt
 */
@Configuration
public class FilterConfig {
    public static final String API_PATH_PREFIX_PATTERN = "^(/api).*";

    @Bean
    public FilterRegistrationBean<NotSupportedIEFilter> ieFilter() {
        FilterRegistrationBean<NotSupportedIEFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new NotSupportedIEFilter(NOT_SUPPORTED_IE_PATH, API_PATH_PREFIX_PATTERN));
        return filterRegistrationBean;
    }
}
