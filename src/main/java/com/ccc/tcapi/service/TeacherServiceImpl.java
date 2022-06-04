package com.ccc.tcapi.service;

import com.ccc.tcapi.dto.RequestTeacher;
import com.ccc.tcapi.entites.TeacherEntity;
import com.ccc.tcapi.repository.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Integer createTeacher(RequestTeacher teacher) {
        TeacherEntity newTeacher = this.teacherRepository.save(teacher.getTeacherEntity());
        return newTeacher.getTeacherRowId();
    }
}
