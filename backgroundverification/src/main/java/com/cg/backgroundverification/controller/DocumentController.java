package com.cg.backgroundverification.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cg.backgroundverification.dto.EmployeeDocumentDTO;
import com.cg.backgroundverification.service.EmployeeDocumentUploadService;

@CrossOrigin
@RestController
public class DocumentController {

	@Autowired
	private EmployeeDocumentUploadService employeeDocumentUploadService;

	@PostMapping(path = "/upload", produces = "application/json")
	public List<String> handleDocumentUpload(@RequestParam("file") MultipartFile file) {

		String uploadMessage = employeeDocumentUploadService.storeDocument(file);
		List<String> strings = new ArrayList<String>();
		strings.add(uploadMessage);
		return strings;
	}

	@GetMapping("/downloadFile/{id}")
	public ResponseEntity<Resource> downloadFile(@PathVariable("id") int id) {
		EmployeeDocumentDTO employeeDocumentDTO = employeeDocumentUploadService.getDocument(id);

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(employeeDocumentDTO.getDocumentType()))
				.body(new ByteArrayResource(employeeDocumentDTO.getData()));
	}
}
