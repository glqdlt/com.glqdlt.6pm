package com.glqdlt.pm6.webcms.web.app;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public final class SpringEnvironmentHolder implements ApplicationContextAware {

    private static ApplicationContext context;
    private static Environment environment;

    @Override
    final public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringEnvironmentHolder.context = applicationContext;
        SpringEnvironmentHolder.environment = context.getEnvironment();

    }

    public static String getProperty(String key) {
        return getEnvironment().getProperty(key);
    }

    public static Environment getEnvironment() {
        return environment;
    }
}
