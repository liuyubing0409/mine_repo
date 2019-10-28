package com.liuyb.service;

import java.util.List;
import java.util.Map;

import com.liuyb.entity.ProductBaseInfo;

public interface ProductService {
	
	public List<ProductBaseInfo> findProducts(String hql, Map<String, Object> params);
}
