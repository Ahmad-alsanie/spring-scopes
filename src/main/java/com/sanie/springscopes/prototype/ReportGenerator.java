package com.sanie.springscopes.prototype;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class ReportGenerator {
    private final List<String> data = new ArrayList<>();

    public void addData(String dataPoint) {
        data.add(dataPoint);
    }

    public List<String> generateReport() {
        return new ArrayList<>(data); // Return a copy of the data
    }
}

