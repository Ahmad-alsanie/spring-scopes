package com.sanie.springscopes.controller;

import com.sanie.springscopes.application.CountryListProvider;
import com.sanie.springscopes.prototype.ReportGenerator;
import com.sanie.springscopes.request.RequestCounter;
import com.sanie.springscopes.session.UserPreferences;
import com.sanie.springscopes.singleton.ConfigurationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;


@RestController
@SessionAttributes("userPreferences")
public class ScopedBeansController {

    private final ConfigurationService configurationService;
    private final RequestCounter requestCounter;
    private final CountryListProvider countryListProvider;
    private final HttpSession httpSession;

    @Autowired
    private org.springframework.beans.factory.ObjectProvider<ReportGenerator> reportGeneratorProvider;

    @Autowired
    public ScopedBeansController(ConfigurationService configurationService, RequestCounter requestCounter, CountryListProvider countryListProvider, HttpSession httpSession) {
        this.configurationService = configurationService;
        this.requestCounter = requestCounter;
        this.countryListProvider = countryListProvider;
        this.httpSession = httpSession;
    }

    @GetMapping("/configuration")
    public String getConfiguration() {
        return "App Name: " + configurationService.getSetting("appName");
    }

    @GetMapping("/incrementRequestCount")
    public String incrementRequestCount() {
        requestCounter.increment();
        return "Request Count: " + requestCounter.getCount();
    }

    @GetMapping("/getCountries")
    public String getCountries() {
        return "Countries: " + String.join(", ", countryListProvider.getCountries());
    }

    @GetMapping("/generateReport")
    public String generateReport() {
        ReportGenerator reportGenerator = reportGeneratorProvider.getObject();
        reportGenerator.addData("Report Data for " + Math.random());
        return "Generated Report: " + reportGenerator.generateReport().toString();
    }

    @GetMapping("/getUserTheme")
    public String getUserTheme() {
        UserPreferences userPreferences = (UserPreferences) httpSession.getAttribute("userPreferences");
        if (userPreferences == null) {
            userPreferences = new UserPreferences();
            httpSession.setAttribute("userPreferences", userPreferences);
        }
        return "User Theme: " + userPreferences.getTheme();
    }

    @GetMapping("/setUserTheme")
    public String setUserTheme(String theme) {
        UserPreferences userPreferences = (UserPreferences) httpSession.getAttribute("userPreferences");
        if (userPreferences == null) {
            userPreferences = new UserPreferences();
            httpSession.setAttribute("userPreferences", userPreferences);
        }
        userPreferences.setTheme(theme);
        return "Theme set to " + theme;
    }
}

