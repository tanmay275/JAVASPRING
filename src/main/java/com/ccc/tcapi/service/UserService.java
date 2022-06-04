package com.ccc.tcapi.service;

import java.util.List;

import com.ccc.tcapi.dto.RequestUser;
import com.ccc.tcapi.dto.ResponseUser;
import com.ccc.tcapi.entites.UserEntity;

public interface UserService {

    public List<ResponseUser> GetOrgUserList(Integer orgRowID);

    public Integer SaveUser(RequestUser orgUser);

    public Integer DeleteUserByRowID(Integer orgRowId);

    public ResponseUser GetUserByCode(String userCode);

    public List<UserEntity> GetOrgUsers();
}
