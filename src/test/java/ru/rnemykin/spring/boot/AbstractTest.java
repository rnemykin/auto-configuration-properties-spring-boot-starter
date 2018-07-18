package ru.rnemykin.spring.boot;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AbstractTest.Configuration.class)
public abstract class AbstractTest {
    @Autowired
    ApplicationContext context;

    @SpringBootApplication
    static class Configuration {
        @ConfigurationProperties("app")
        static class AppProperties {
        }
    }
}