package com.ccc.tcapi.controller;

import java.util.List;

import com.ccc.tcapi.dto.RequestSemester;
import com.ccc.tcapi.entites.SemesterEntity;
import com.ccc.tcapi.service.SemesterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/semester")
public class SemesterController {

    @Autowired
    SemesterService semesterContext;

    @GetMapping(value = "/list")
    public ResponseEntity<List<SemesterEntity>> GetAllSemesterList() {
        List<SemesterEntity> semester = semesterContext.GetAllSemesterList();
        return ResponseEntity.ok(semester);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<String> SaveSemester(@RequestBody RequestSemester semester) {
        Integer response = semesterContext.SaveSemester(semester);
        if (response > 0) {
            return ResponseEntity.ok("Semester saved successfully");
        }
        return ResponseEntity.ok("OPPS: Something went wrong.");
    }

    // @PostMapping(value = "api/allSemester/save")
    // public ResponseEntity<String> SaveSemesters(@RequestBody
    // List<RequestSemester> semester) {
    // Integer response = semesterContext.SaveSemesters(semester);
    // if (response > 0) {
    // return ResponseEntity.ok("Semester saved successfully");
    // }
    // return ResponseEntity.ok("OPPS: Something went wrong.");
    // }
}
