/**
 * 
 */
package com.school.service.model;

import java.io.Serializable;

/**
 * @author SSTPL
 *
 */
public class Student implements Serializable {

	/**
	 * 
	 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7096246489129351374L;
	/**
	 * 
	 */
	
	private String studentId;
	private String fullName;
	private String address;
		

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

}
