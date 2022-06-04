package com.ccc.tcapi.controller;

import com.ccc.tcapi.dto.RequestTeacher;
import com.ccc.tcapi.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/save")
    public ResponseEntity<String> saveTeacher(@RequestBody RequestTeacher teacher) {
        int response = this.teacherService.createTeacher(teacher);
        if (response > 0)
            return ResponseEntity.ok("Teacher created successfully");
        else
            return ResponseEntity.ok("Opps! somthing went wrong!!");

    }
}
