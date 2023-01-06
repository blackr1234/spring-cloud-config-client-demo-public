package code;

import static lombok.AccessLevel.PRIVATE;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.validation.constraints.Pattern;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@FieldDefaults(level = PRIVATE)
@Validated
@Configuration
@ConfigurationProperties(prefix = "order-test", ignoreUnknownFields = false)
public class ConfigFileLoadOrderTestConfig {

    @Pattern(regexp = "^application.yaml$") String loadOrder01;
    @Pattern(regexp = "^spring-cloud-config-client-demo.yaml$") String loadOrder02;
    @Pattern(regexp = "^application-dev.yaml$") String loadOrder03;
    @Pattern(regexp = "^spring-cloud-config-client-demo-dev.yaml$") String loadOrder04;



    @PostConstruct
    public void afterPropertiesSet() {
        log.info("Initializing {}", getClass());
        log.info("order-test object: {}", this);
    }

    @PreDestroy
    public void destroy() throws Exception {
        log.info("Destroying {}", getClass());
    }
}
