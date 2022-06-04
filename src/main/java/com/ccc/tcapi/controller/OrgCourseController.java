package com.ccc.tcapi.controller;

import java.util.List;

import com.ccc.tcapi.dto.RequestOrgCourse;
import com.ccc.tcapi.entites.OrgCourseEntity;
import com.ccc.tcapi.service.OrgCourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/course")
public class OrgCourseController {

    @Autowired
    OrgCourseService courseContext;

    @GetMapping(value = "/list")
    public ResponseEntity<List<OrgCourseEntity>> GetAllOrgCourse() {
        List<OrgCourseEntity> course = courseContext.GetAllOrgCourse();
        return ResponseEntity.ok(course);
    }

    @GetMapping(value = "/list/by/{orgRowId}")
    public ResponseEntity<List<OrgCourseEntity>> GetCourseByOrgRowId(@PathVariable("orgRowId") Integer orgRowId) {
        List<OrgCourseEntity> course = courseContext.GetCourseByOrgRowId(orgRowId);
        return ResponseEntity.ok(course);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<String> SaveOrgCourse(@RequestBody RequestOrgCourse course) {
        Integer response = courseContext.SaveOrgCourse(course);
        if (response > 0) {
            return ResponseEntity.ok("Course saved successfully");
        }
        return ResponseEntity.ok("OPPS: Something went wrong.");
    }
}
