package com.glqdlt.pm6.webcms.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.glqdlt.pm6.jpapersistence.*")
@EntityScan(basePackages = "com.glqdlt.pm6.jpapersistence.*")
@Configuration
public class DbConfig {
}
