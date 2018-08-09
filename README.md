### Auto registration to context, classes marked as @ConfigurationProperties

Add to your classpath
```yaml
<dependency>
    <groupId>ru.rnemykin.spring</groupId>
    <artifactId>auto-configuration-properties-spring-boot-starter</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

Write code 
```java
@ConfigurationProperties("app")
public class AppProperties {
    String apiUrl;
    
    //getters & setters
}
```

and forget about _@EnableConfigurationProperties_.
Starter will automatically register @ConfigurationProperties classes to context.

Now you can inject it in other beans
```java
@Autowired
AppProperties properties;
```
