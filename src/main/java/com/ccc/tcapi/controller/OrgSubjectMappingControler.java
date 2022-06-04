package com.ccc.tcapi.controller;

import java.util.List;

import com.ccc.tcapi.dto.RequestOrgSubjectMapping;
import com.ccc.tcapi.entites.OrgSubjectMappingEntity;
import com.ccc.tcapi.service.OrgSubjectMappingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/subject")
public class OrgSubjectMappingControler {

    @Autowired
    OrgSubjectMappingService subjectMappingContext;

    @GetMapping(value = "/list")
    public ResponseEntity<List<OrgSubjectMappingEntity>> GetAllOrgSubjectMapping() {
        List<OrgSubjectMappingEntity> subject = subjectMappingContext.GetAllOrgSubjectMapping();
        return ResponseEntity.ok(subject);
    }

    @GetMapping(value = "/list/by/{orgRowId}")
    public ResponseEntity<List<OrgSubjectMappingEntity>> GetSubjectsByOrgRowId(@PathVariable("orgRowId") Integer orgRowId) {
        List<OrgSubjectMappingEntity> subject = subjectMappingContext.GetSubjectsByOrgRowId(orgRowId);
        return ResponseEntity.ok(subject);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<String> SaveOrgSubjectMapping(@RequestBody RequestOrgSubjectMapping subject) {
        Integer response = subjectMappingContext.SaveOrgSubjectMapping(subject);
        if (response > 0) {
            return ResponseEntity.ok("Subject saved successfully");
        }
        return ResponseEntity.ok("OPPS: Something went wrong.");
    }
}
