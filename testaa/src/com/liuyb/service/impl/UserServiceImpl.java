package com.liuyb.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuyb.dao.BaseDao;
import com.liuyb.entity.UserInfo;
import com.liuyb.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private BaseDao<UserInfo> userDao;

	@Override
	public UserInfo login(String hql, Map<String, Object> params) {
		return userDao.getByHql(hql, params);
	}

	@Override
	public UserInfo findUserById(Integer id) {
		return userDao.getById(UserInfo.class, id);
	}

}
