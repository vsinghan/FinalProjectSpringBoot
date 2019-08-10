package com.cg.backgroundverification.dao;

import com.cg.backgroundverification.dto.EmployeeDocumentDTO;

public interface EmployeeDocumentDao {

	String uploadDocument(EmployeeDocumentDTO employeeDocumentDTO);
	
	EmployeeDocumentDTO findById(int id);
}
