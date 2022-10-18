package com.app.crud.serviceinterface;

import java.util.List;

import com.app.crud.model.Employee;

public interface ServiceInterface {

	public Employee saveEmployee(Employee employee);

	public String editEmployee(Integer eid, Employee employee);

	public String deleteEmployee(Integer eid);

	public List<Employee> getAllEmployee();

	public Employee getSingleEmployee(Integer eid);

}
