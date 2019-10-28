package com.liuyb.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuyb.dao.BaseDao;
import com.liuyb.entity.ProductBaseInfo;
import com.liuyb.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private BaseDao<ProductBaseInfo> productDao;

	@Override
	public List<ProductBaseInfo> findProducts(String hql, Map<String, Object> params) {
		return productDao.find(hql, params);
	}

}
