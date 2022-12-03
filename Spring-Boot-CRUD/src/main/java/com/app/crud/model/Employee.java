package com.app.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//this is git hub tutorial
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Employee")             // employee table name
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer eid;
	
	@Column(name = "EmployeeName")           // employee_name column name
	String ename;
	
	String designation;
	String address;
}
// For the practice of Github

// Addaed by Tejas For Git Practise

// added by Namrata for git