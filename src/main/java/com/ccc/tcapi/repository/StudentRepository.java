package com.ccc.tcapi.repository;

import com.ccc.tcapi.entites.StudentEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

}
