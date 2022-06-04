package com.ccc.tcapi.controller;

import com.ccc.tcapi.dto.RequestOrgCourseSem;
import com.ccc.tcapi.service.OrgCourseSemServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/courseSem")
public class OrgCourseSemController {

    @Autowired
    OrgCourseSemServiceimpl courseSemContex;

    @PostMapping(value = "/save")
    public ResponseEntity<String> SaveCountry(@RequestBody RequestOrgCourseSem courseSem) {
        Integer response = courseSemContex.SaveCourseSem(courseSem);
        if (response > 0) {
            return ResponseEntity.ok("Course Sem saved successfully");
        }
        return ResponseEntity.ok("OPPS: Something went wrong.");
    }
}
