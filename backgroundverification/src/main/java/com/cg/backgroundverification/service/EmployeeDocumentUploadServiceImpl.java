package com.cg.backgroundverification.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.cg.backgroundverification.dao.EmployeeDocumentDao;
import com.cg.backgroundverification.dto.EmployeeDocumentDTO;
import com.cg.backgroundverification.exception.DocumentUploadException;

@Service
public class EmployeeDocumentUploadServiceImpl implements EmployeeDocumentUploadService {

	@Autowired
	private EmployeeDocumentDao employeeDocumentDao;

	public String storeDocument(MultipartFile file) {
		// Normalize file name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			// Check if the file's name contains invalid characters
			// if(fileName.contains("..")) {
			// throw new FileStorageException("Sorry! Filename contains invalid path
			// sequence " + fileName);
			EmployeeDocumentDTO employeeDocumentDTO = new EmployeeDocumentDTO(file.getContentType(), file.getBytes());

			return employeeDocumentDao.uploadDocument(employeeDocumentDTO);

			// }

		} catch (IOException ex) {
			throw new DocumentUploadException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

	public EmployeeDocumentDTO getDocument(int id) {
		return employeeDocumentDao.findById(id);
		// .orElseThrow(() -> new MyFileNotFoundException("File not found with id " +
		// fileId));
	}
}
