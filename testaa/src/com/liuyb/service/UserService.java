package com.liuyb.service;

import java.util.Map;

import com.liuyb.entity.UserInfo;

public interface UserService {
	public UserInfo login(String hql, Map<String, Object> params);
	
	public UserInfo findUserById(Integer id);
}
