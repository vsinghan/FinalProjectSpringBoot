package com.cg.backgroundverification.dto;

import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="employee_document")
public class EmployeeDocumentDTO {

	@Id 
//	@GeneratedValue(strategy=GenerationType.IDENTITY) //for mysql
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passenger_seq")
	@SequenceGenerator(name = "passenger_seq", sequenceName = "passenger_seq", allocationSize = 1)
    private int id; 
     
//    @Column(name="name", length=100, nullable=false)
//    private String documentName;
     
    @Column(name="type")
    private String documentType;
     
    @Lob 
    @Basic(fetch = FetchType.LAZY)
    @Column(name="content")
    private byte[] data;

    
	public EmployeeDocumentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	



	public EmployeeDocumentDTO(int id) {
		super();
		this.id = id;
	}





	public EmployeeDocumentDTO(String documentType, byte[] data) {
		super();
		this.documentType = documentType;
		this.data = data;
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "EmployeeDocumentDTO [id=" + id + ", documentType=" + documentType + ", data=" + Arrays.toString(data)
				+ "]";
	}
 
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "employee_id")
//    private EmployeeDTO employeeDTO; 
    
    
}
