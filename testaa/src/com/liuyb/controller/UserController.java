package com.liuyb.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liuyb.entity.UserInfo;
import com.liuyb.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService UserService;

	@RequestMapping("/index")
	@ResponseBody
	public Object index(HttpServletRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("loginid", request.getParameter("loginid"));
		params.put("password", request.getParameter("password"));
		String hql = " from UserInfo where loginid =:loginid and password =:password ";
		UserInfo userInfo = UserService.login(hql, params);
		if(userInfo==null) {
			return "fail";
		}
		return "success";
	}
}
