package com.example.docker.services;


import com.example.docker.model.GradeEntryRequest;

import java.util.List;
import java.util.Map;

public interface GradeService {
    void enterGrade(GradeEntryRequest request);
    List<Map<String, Object>> getAllGrades();}
