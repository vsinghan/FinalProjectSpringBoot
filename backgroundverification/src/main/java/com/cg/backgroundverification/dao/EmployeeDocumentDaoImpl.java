/**
 * 
 */
package com.cg.backgroundverification.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.backgroundverification.dto.EmployeeDocumentDTO;

/**
 * @author trainee
 *
 */
@Repository
@Transactional
public class EmployeeDocumentDaoImpl implements EmployeeDocumentDao {

	@PersistenceContext
	private EntityManager entityManager;

	public String uploadDocument(EmployeeDocumentDTO employeeDocumentDTO) {
		entityManager.persist(employeeDocumentDTO);
		return "uploaded successfully";
	}

	@Override
	public EmployeeDocumentDTO findById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(EmployeeDocumentDTO.class, id);
	}
}
