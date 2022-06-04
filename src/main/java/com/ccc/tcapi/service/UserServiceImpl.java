package com.ccc.tcapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ccc.tcapi.dto.RequestUser;
import com.ccc.tcapi.dto.ResponseUser;
import com.ccc.tcapi.entites.UserEntity;
import com.ccc.tcapi.repository.UserRepository;
import com.ccc.tcapi.repository.OrganizationRepository;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public List<ResponseUser> GetOrgUserList(Integer orgRowID) {
        List<ResponseUser> users = this.organizationRepository.findByOrgRowID(orgRowID);
        return users;
    }

    @Override
    public List<UserEntity> GetOrgUsers() {
        return userRepository.findAll();
    }

    @Override
    public Integer SaveUser(RequestUser user) {
        UserEntity newUser = this.userRepository.save(user.getUser());
        return newUser.getUserRowID();
    }

    @Override
    public Integer DeleteUserByRowID(Integer orgRowId) {
        return null;
    }

    @Override
    public ResponseUser GetUserByCode(String userCode) {
        return userRepository.findByUserCode(userCode);
    }
}
