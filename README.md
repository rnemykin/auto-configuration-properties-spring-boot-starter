### Auto registration to context, classes marked as @ConfigurationProperties

Add to your classpath
```yaml
<dependency>
    <groupId>ru.rnemykin.spring</groupId>
    <artifactId>auto-configuration-properties-spring-boot-starter</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

Write code and forget about @EnableConfigurationProperties.
Starter will automatically register @ConfiguratioProperties classes 
