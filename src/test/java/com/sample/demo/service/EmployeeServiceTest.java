package com.sample.demo.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.demo.mappers.EmployeeMapper;
import com.sample.demo.vo.Criteria;
import com.sample.demo.vo.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/META-INF/spring/app-context.xml"})
public class EmployeeServiceTest {

	@Autowired
	EmployeeMapper employeeMapper;
	
	@Test
	public void testSearchEmployees() {
		Criteria c = new Criteria();

		c.setJobs(Arrays.asList("IT_PROG"));
		c.setMinSalary(new Long(5000));
		c.setMaxSalary(new Long(20000));
		c.setBeginDate("2005-12-10");
	
		List<Employee> employees = employeeMapper.searchEmployees(c);
		
		Assert.assertEquals(2, employees.size());
	}
	
	@Test
	public void testSearchEmployees2() {
		Criteria c = new Criteria();
		c.setOpt("name");
		c.setKeyword("Neena");
		
		List<Employee> employees = employeeMapper.searchEmployees(c);
		
		Assert.assertEquals(1, employees.size());
	}
	
}
