package com.sanie.springscopes.application;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.ArrayList;
import java.util.List;

@Component
@ApplicationScope
public class CountryListProvider {
    private List<String> countries = new ArrayList<>();

    public CountryListProvider() {
        // Imagine this data comes from an external service or database
        countries.add("United States");
        countries.add("Canada");
        countries.add("Mexico");
    }

    public List<String> getCountries() {
        return countries;
    }
}
