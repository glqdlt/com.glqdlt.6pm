package com.glqdlt.pm6.persistence;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest()
@RunWith(SpringRunner.class)
public class Pm6PersistenceInitTest {

    @EnableAutoConfiguration
    @SpringBootConfiguration()
    @ComponentScan(basePackages = "com.glqdlt.pm6.persistence.**")
    @EntityScan(basePackages = "com.glqdlt.pm6.persistence.**")
    public static class JpaTestEntityScanConfig {

    }

    @Autowired
    private TestEntityManager testEntityManager;


    @Test
    public void loadTestEntityManager() {
        Assert.assertNotNull(testEntityManager);
    }

}