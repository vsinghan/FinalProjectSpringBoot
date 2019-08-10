package com.cg.backgroundverification.service;

import org.springframework.web.multipart.MultipartFile;

import com.cg.backgroundverification.dto.EmployeeDocumentDTO;

public interface EmployeeDocumentUploadService {

	String storeDocument(MultipartFile file);
	
	EmployeeDocumentDTO getDocument(int id);
}
