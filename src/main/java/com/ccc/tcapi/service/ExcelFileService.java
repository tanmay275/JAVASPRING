package com.ccc.tcapi.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.ccc.tcapi.entites.Contact;


public interface ExcelFileService {
	
	ByteArrayInputStream export(List<Contact> contacts);
	
}
