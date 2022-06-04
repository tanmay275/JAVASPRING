package com.ccc.tcapi.controller;

import java.util.List;

import javax.validation.Valid;

import com.ccc.tcapi.dto.RequestUser;
import com.ccc.tcapi.dto.ResponseUser;
import com.ccc.tcapi.entites.UserEntity;
import com.ccc.tcapi.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "save")
    public ResponseEntity<String> SaveUser(@Valid @RequestBody RequestUser user) {
        int response = this.userService.SaveUser(user);
        if (response > 0)
            return ResponseEntity.ok("User saved successfully.");
        else
            return ResponseEntity.ok("Can not saved user due to some internal issue.");
    }

    @GetMapping(value = "list/{orgRowId}")
    public ResponseEntity<List<ResponseUser>> GetUsersByOrg(@PathVariable("orgRowId") Integer orgRowId) {
        return ResponseEntity.ok(this.userService.GetOrgUserList(orgRowId));
    }

    @GetMapping(value = "list")
    public ResponseEntity<List<UserEntity>> GetUsers() {
        return ResponseEntity.ok(this.userService.GetOrgUsers());
    }
    
    @GetMapping(value = "details/by/code/{userCode}")
    public ResponseEntity<ResponseUser> GetUsersByCode(@PathVariable("userCode") String userCode) {
        return ResponseEntity.ok(this.userService.GetUserByCode(userCode));
    }

}
