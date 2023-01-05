package code;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RefreshScope
@Component
public class MyComponent {

    @Value("${my.prop:not-found}")
    private String myProp;

    @Value("${my.prop2:not-found}")
    private String myProp2;

    @PostConstruct
    public void init() {
        log.info("my.prop: {}", myProp);
        log.info("my.prop2: {}", myProp2);
    }

    @EventListener
    public void refresh(RefreshScopeRefreshedEvent event) {
        log.info("Refreshed class [{}].", getClass().getName());
    }
}