package com.liuyb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liuyb.entity.ProductBaseInfo;
import com.liuyb.service.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/findAll.do")
	@ResponseBody
	public List<ProductBaseInfo> findProducts(HttpServletRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer();
		hql.append(" from ProductBaseInfo where 1=1 ");
		String prodName = request.getParameter("prodName");
		if(prodName!=null && !"".equals(prodName.trim())) {
			hql.append(" and prodName like :prodName ");
			params.put("prodName", "%'" + prodName + "'%");
		}
		return productService.findProducts(hql.toString(), params);
	}
	

}
