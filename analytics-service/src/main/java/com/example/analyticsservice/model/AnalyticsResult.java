package com.example.analyticsservice.model;

// AnalyticsResult.java
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "analyticsResults")
public class AnalyticsResult {

    @Id
    private String id;
    private double maxGrade;
    private double minGrade;
    private double averageGrade;

    public AnalyticsResult(double maxGrade, double minGrade, double averageGrade) {
        this.maxGrade = maxGrade;
        this.minGrade = minGrade;
        this.averageGrade = averageGrade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMaxGrade() {
        return maxGrade;
    }

    public void setMaxGrade(double maxGrade) {
        this.maxGrade = maxGrade;
    }

    public double getMinGrade() {
        return minGrade;
    }

    public void setMinGrade(double minGrade) {
        this.minGrade = minGrade;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }
}
