package com.liuyb.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.ws.Endpoint;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class TestConstruct {

	@PostConstruct
	public void test() {
		for (int i = 0; i < 10; i++) {
			System.out.println("------------->>>>> "+ i);
		}
		
		Endpoint.publish("http://192.168.19.128:8090/testwebservice", new TestWebServiceImpl());
		
		System.out.println("http://192.168.19.128:8090/testwebservice  发布成功");
	}
	
	public static void main(String[] args) {
		HttpClient client = new HttpClient() ;
		PostMethod method = null;//post 方式   get 方式 GetMethod gMethod
	    String result = "" ;
	    try {
	        method = new PostMethod("http://192.168.19.128:8080/MyService/interface/test3.do");
	        method.setParameter("userid", "2");//设置参数
	        client.executeMethod(method);
	        if(method.getStatusCode() == HttpStatus.SC_OK){//响应成功
	            result = method.getResponseBodyAsString();//调用返回结果
	            System.out.println("success:"+result);
	        }else{//不成功组装结果
	            Map<String , Object >map = new HashMap<String , Object>();
	            Gson gson = new Gson() ;
	            map.put("success", false);
	            result = gson.toJson(map);
	            System.out.println("fail:"+result);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }finally{
	    	method.releaseConnection();
	    }

	}
}
