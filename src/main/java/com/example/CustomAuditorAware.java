package com.example;

import org.springframework.data.domain.AuditorAware;

public class CustomAuditorAware implements AuditorAware<String> { // this is "string" should match "createdBy" or "lastModiedBy" field types
    @Override
    public String getCurrentAuditor() {
        return "Mahdi Tajik";
    }
}
