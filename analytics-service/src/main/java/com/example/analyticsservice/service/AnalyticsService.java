package com.example.analyticsservice.service;

// AnalyticsService.java
import com.example.analyticsservice.model.AnalyticsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnalyticsService {

    private final JdbcTemplate jdbcTemplate;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public AnalyticsService(JdbcTemplate jdbcTemplate, MongoTemplate mongoTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.mongoTemplate = mongoTemplate;
    }

    @Transactional
    public void performAnalytics() {
        // Perform analytics using JDBC Template
        double maxGrade = jdbcTemplate.queryForObject("SELECT MAX(grade) FROM students", Double.class);
        double minGrade = jdbcTemplate.queryForObject("SELECT MIN(grade) FROM students", Double.class);
        double averageGrade = jdbcTemplate.queryForObject("SELECT AVG(grade) FROM students", Double.class);

        // Save results to MongoDB
        AnalyticsResult analyticsResult = new AnalyticsResult(maxGrade, minGrade, averageGrade);
        mongoTemplate.save(analyticsResult, "analyticsResults");
    }
}
