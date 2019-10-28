package com.liuyb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liuyb.service.UserService;

@Controller
@RequestMapping("interface")
public class MyInterface {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/test1")
	@ResponseBody
	public Object method1(HttpServletRequest request) {
		return userService.findUserById(1);
	}
	
	@RequestMapping("/test2")
	@ResponseBody
	public Object method2(@RequestBody Integer userid) {
		return userService.findUserById(userid);
	}
	
	@RequestMapping("/test3")
	@ResponseBody
	public Object method3(String userid) {
		return userService.findUserById(Integer.valueOf(userid));
	}
}
