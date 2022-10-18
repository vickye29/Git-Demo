package com.app.crud.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.app.crud.exception.AllFieldMandatoryException;
import com.app.crud.exception.NullValueException;
import com.app.crud.model.Employee;
import com.app.crud.repository.CrudRepository;
import com.app.crud.serviceinterface.ServiceInterface;

@Service
public class ServiceImpl implements ServiceInterface {

	@Autowired
	CrudRepository crudRepository;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		
		if(employee.getEname()!=null && employee.getDesignation() != null && employee.getAddress() !=null)
		{
			return crudRepository.save(employee);
		}
		else {
			 throw new AllFieldMandatoryException("ALL FIELDS ARE NOT PRESENT");         //Throw AllFieldMandatoryExeption
		}
		
	}

	@Override
	public String editEmployee(Integer eid, Employee employee) {
		
		Optional<Employee> op = crudRepository.findById(eid);
		
		if(op.isPresent())
		{
			
			if(employee.getEname()!=null)
			{
				employee.setEid(eid);
				crudRepository.save(employee);
				return "Employee Updated Succefully";
			}
			else
			{
				throw new NullValueException("EMPLOYEE NAME IS NULL");               // Throw Simple NullValueException 
			}
			
		}
		else
		{
			return "Employee is NOT Present";
		}
	}

	@Override
	public String deleteEmployee(Integer eid) {
		
		try {
			crudRepository.deleteById(eid);
		} catch (EmptyResultDataAccessException e) {
			return "NO DATA PRESENT";
		}
		
		return "Deleted Successfully";
	}

	@Override
	public List<Employee> getAllEmployee() {
		return crudRepository.findAll();
	}

	@Override
	public Employee getSingleEmployee(Integer eid) {
		Optional<Employee> optional=crudRepository.findById(eid);
		if(optional.isPresent())
		{
			return optional.get();
		}
		else {
			return null;
		}
		
	}

	
}
