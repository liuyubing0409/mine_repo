package com.liuyb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	
	@RequestMapping("index")
	@ResponseBody
	public Object empIndex() {
		return "Employee--Success";
	}

}
