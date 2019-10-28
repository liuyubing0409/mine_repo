package com.liuyb.web;
import javax.jws.WebService;

@WebService(serviceName="TestWebServiceImplService")
public class TestWebServiceImpl {
	
	//@Override
	public int add(int a, int b) {
		return a+b;
	}
	
	//@WebMethod
	public float sub(float a, float b) {
		return a-b;
	}
	
	//@WebMethod(exclude=true)
	public int div(int a, int b) {
		return a/b;
	}


}
