package com.ccc.tcapi.controller;

import com.ccc.tcapi.dto.RequestStudent;
import com.ccc.tcapi.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<String> SaveStudent(@RequestBody RequestStudent student) {
        
        int response = this.studentService.CreateStudent(student);
        if (response > 0)
            return ResponseEntity.ok("Student created successfully");
        else
            return ResponseEntity.ok("Opps! somthing went wrong!!");

    }

}
