package com.example.docker.controllers;

import com.example.docker.model.GradeEntryRequest;
import com.example.docker.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enter")
public class DataEntryController {

    private final GradeService gradeService;

    @Autowired
    public DataEntryController(GradeService gradeService) {

        this.gradeService = gradeService;
    }

    @PostMapping("/enter-grade")
    public void enterGrade(@RequestBody GradeEntryRequest request) {

        gradeService.enterGrade(request);
    }



}
