package ru.kpfu.itis.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionHistory {

    private Double result;

    public Double getResult() {
        return result;
    }

    public void addResult(Double result) {
        this.result = result;
    }
}
