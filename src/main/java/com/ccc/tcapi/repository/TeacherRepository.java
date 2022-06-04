package com.ccc.tcapi.repository;

import com.ccc.tcapi.entites.TeacherEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Integer> {

}
