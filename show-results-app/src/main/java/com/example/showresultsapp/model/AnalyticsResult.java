package com.example.showresultsapp.model;
public class AnalyticsResult {
    private double maxGrade;
    private double minGrade;
    private double averageGrade;

    public AnalyticsResult() {
    }

    public AnalyticsResult(double maxGrade, double minGrade, double averageGrade) {
        this.maxGrade = maxGrade;
        this.minGrade = minGrade;
        this.averageGrade = averageGrade;
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
