package com.ccc.tcapi.service;

import com.ccc.tcapi.dto.RequestStudent;
import com.ccc.tcapi.entites.StudentEntity;
import com.ccc.tcapi.entites.UserEntity;
import com.ccc.tcapi.repository.StudentRepository;
import com.ccc.tcapi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public Integer CreateStudent(RequestStudent student) {

        // Save user first
        UserEntity newUser = userRepo.save(student.getStudent().getUser());
        student.getStudent().setUser(newUser);

        StudentEntity newStudent = this.studentRepo.save(student.getStudent());
        return newStudent.getStdRowId();
    }

}
