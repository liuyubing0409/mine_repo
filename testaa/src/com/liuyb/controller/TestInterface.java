package com.liuyb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("testInterface")
public class TestInterface {

	@RequestMapping("/testf1")
	public void test1(HttpServletRequest request) {
		String url = "http://192.168.19.128:8080/MyService/interface/test1";
		//HttpClient client = null;
		
		try {
			//client = new HttpGet(url);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
