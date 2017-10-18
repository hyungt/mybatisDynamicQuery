package com.sample.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.demo.mappers.EmployeeMapper;
import com.sample.demo.vo.Criteria;
import com.sample.demo.vo.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	public List<Employee> searchEmployees(Criteria c) {
		if(c == null) {
			throw new IllegalArgumentException("조건을 다시 확인");
		}
		return employeeMapper.searchEmployees(c);
	}

	
}
