package com.game.grizzly.app.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.game.grizzly.app.bean.Employee;
import com.game.grizzly.app.bean.EmployeeList;
import com.game.grizzly.app.ds.EmployeeDS;

@Controller
@RequestMapping("/rest")
public class RestEmployeeController {
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private EmployeeDS employeeDS;

	@RequestMapping(method = RequestMethod.GET, value = "/emp/{id}", headers = "Accept=application/json")
	public @ResponseBody
	Employee getEmp(@PathVariable String id) {
		Employee e = employeeDS.get(Long.parseLong(id));
		return e;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/emps", headers = "Accept=application/json")
	public @ResponseBody EmployeeList list() {
		EmployeeList list = new EmployeeList();
		list.setCount(employeeDS.getAll().size());
		list.setEmployees(employeeDS.getAll());
		return list;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/emp")
	public @ResponseBody Employee addEmp(@RequestBody Employee e) {
		logger.info(e);
		employeeDS.add(e);
		return e;
	}
}
