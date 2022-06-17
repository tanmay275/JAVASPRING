package com.ccc.tcapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ccc.tcapi.entites.Contact;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}