package com.sanie.springscopes.singleton;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConfigurationService {
    private final Map<String, String> settings = new HashMap<>();

    public ConfigurationService() {
        // Initialize with some default settings
        settings.put("appName", "SpringScopesDemo");
    }

    public String getSetting(String key) {
        return settings.getOrDefault(key, "Not Found");
    }
}
