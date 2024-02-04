package com.sanie.springscopes.request;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.stereotype.Component;

@Component
@RequestScope
public class RequestCounter {
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    @PostConstruct
    public void init() {
        // Initialization logic, if needed
    }

    @PreDestroy
    public void destroy() {
        // Cleanup resources, if needed
    }
}

