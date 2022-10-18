package com.app.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.crud.model.Employee;
import com.app.crud.serviceinterface.ServiceInterface;


@RestController
public class HomeController {

	@Autowired
	ServiceInterface serviceInterface;
	
	@PostMapping(value = "/employee", consumes = "application/JSON" )
	public Employee saveEmployee(@RequestBody Employee employee)
	{
		System.out.println("For Git Practice");
		return serviceInterface.saveEmployee(employee);
	}
	// GIt Practice 
	
	@PutMapping(value = "/employee/{eid}", consumes = "application/JSON" )
	public String editEmployee(@RequestBody Employee employee, @PathVariable ("eid") Integer eid)
	{
		System.out.println("Data Updated");
		return serviceInterface.editEmployee(eid,employee);
	}
	
	
	@DeleteMapping(value = "/employee/{eid}", consumes = "application/JSON")
	public String deleteEmployee(@PathVariable ("eid") Integer eid)
	{
		return serviceInterface.deleteEmployee(eid);
	}
	
	@GetMapping(value = "/employee", produces = "application/JSON")
	public List<Employee> getAllEmployee()
	{
		return serviceInterface.getAllEmployee();
	}
	
	@GetMapping(value = "/employee/{eid}",consumes = "application/JSON", produces = "application/JSON")
	public Employee getAllEmployee( @PathVariable ("eid") Integer eid)
	{
		return serviceInterface.getSingleEmployee(eid);
	}
	
}
