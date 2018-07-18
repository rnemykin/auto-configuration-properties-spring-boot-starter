package ru.rnemykin.spring.boot;

import com.google.common.collect.Iterables;
import org.reflections.Reflections;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "configuration.properties.register.enabled", havingValue = "true", matchIfMissing = true)
public class ConfigurationPropertiesAutoConfiguration implements BeanDefinitionRegistryPostProcessor {

    public void postProcessBeanDefinitionRegistry(final BeanDefinitionRegistry registry) throws BeansException {
        Reflections reflections = new Reflections("");
        Class<?> sbaClass = Iterables.getFirst(reflections.getTypesAnnotatedWith(SpringBootApplication.class), null);
        if(sbaClass != null) {
            reflections = new Reflections(sbaClass.getPackage().getName());
            for (Class<?> cl : reflections.getTypesAnnotatedWith(ConfigurationProperties.class)) {
                ConfigurationProperties annotation = cl.getAnnotation(ConfigurationProperties.class);
                String beanName = annotation.value() + "-" + cl.getName();
                registry.registerBeanDefinition(beanName, new AnnotatedGenericBeanDefinition(cl));
            }
        }
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    }

}
