package com.liuyb.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.liuyb.entity.UserInfo;
import com.liuyb.service.UserService;

@Controller
public class SysController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login.do")
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("loginid", request.getParameter("loginid"));
		params.put("password", request.getParameter("password"));
		String hql = " from UserInfo where loginid =:loginid and password =:password ";
		UserInfo userInfo = userService.login(hql, params);
		if(userInfo==null) {
			mv.setViewName("productList");
			return mv;
		}
		HttpSession session = request.getSession();
		session.setAttribute("currUser", userInfo);
		mv.setViewName("productList");
		return mv;
	}

}
