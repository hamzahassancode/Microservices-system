package com.example.docker.services;

import com.example.docker.model.GradeEntryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GradeServiceImpl implements GradeService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GradeServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void enterGrade(GradeEntryRequest request) {
        String sql = "INSERT INTO grades (studentName, grade) VALUES (?, ?)";
        jdbcTemplate.update(sql, request.getStudentName(), request.getGrade());
    }
    @Override
    public List<Map<String, Object>> getAllGrades() {
        String sql = "SELECT * FROM grades";
        return jdbcTemplate.queryForList(sql);
    }

}
