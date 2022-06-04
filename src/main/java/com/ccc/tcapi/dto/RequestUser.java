package com.ccc.tcapi.dto;

import com.ccc.tcapi.entites.UserEntity;

public class RequestUser {

    public UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

}
