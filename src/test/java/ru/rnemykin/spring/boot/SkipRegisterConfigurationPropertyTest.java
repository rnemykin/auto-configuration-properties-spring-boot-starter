package ru.rnemykin.spring.boot;

import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = {"configuration.properties.register.enabled=false"})
public class SkipRegisterConfigurationPropertyTest extends AbstractTest {

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void contextLoad() {
        context.getBean(Configuration.AppProperties.class);
    }

}
