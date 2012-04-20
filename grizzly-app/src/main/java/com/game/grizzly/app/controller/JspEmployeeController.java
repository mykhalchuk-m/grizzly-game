package com.game.grizzly.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.game.grizzly.app.ds.EmployeeDS;

@Controller
public class JspEmployeeController {
	@Autowired
	private EmployeeDS employeeDS;

	@RequestMapping("/employees")
	public String emploees(Model model) {
		model.addAttribute("employees", employeeDS.getAll());
		return "employees";
	}
}
