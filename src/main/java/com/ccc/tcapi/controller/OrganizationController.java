package com.ccc.tcapi.controller;

import java.util.List;

import javax.validation.Valid;

import com.ccc.tcapi.dto.RequestOrganization;
import com.ccc.tcapi.dto.ResponseOrg;
import com.ccc.tcapi.entites.OrganizationEntity;
import com.ccc.tcapi.service.OrganizationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/org")
public class OrganizationController {
  
    @Autowired
    private OrganizationService organizationService;

    @PostMapping(value = "/save")
    public ResponseEntity<String> SaveOrg(@Valid @RequestBody RequestOrganization requestOrganization) {

        int orgRowId = this.organizationService.saveOrganizaton(requestOrganization);

        if (orgRowId > 0) {
            return ResponseEntity.ok("Organization created SuccessFully.");
        } else {
            return ResponseEntity.ok("Opps! Somthing went wrong!!");
        }
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<OrganizationEntity>> GetOrganizationList() {
        List<OrganizationEntity> orgList = organizationService.GetOrgList();
        return ResponseEntity.ok(orgList);
    }

    @GetMapping(value = "by/{orgRowID}")
    public ResponseEntity<ResponseOrg> GetOrganizationByID(@PathVariable("orgRowID") Integer orgRowID) {
        ResponseOrg organization = organizationService.GetOrgByID(orgRowID);
        return ResponseEntity.ok(organization);
    }

    // @PutMapping(value = "api/update/org")
    // public ResponseEntity<String> UpdateOrg()
}
