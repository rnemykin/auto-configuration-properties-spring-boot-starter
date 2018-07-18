package ru.rnemykin.spring.boot;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class RegisterConfigurationPropertyClassTest extends AbstractTest {

    @Test
    public void contextLoad() {
        Configuration.AppProperties appProperties = context.getBean(Configuration.AppProperties.class);
        assertNotNull(appProperties);
    }

}
