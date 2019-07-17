package com.woniu.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class A implements Interceptor{

	@Override
	public void destroy() {
	}
	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("----------");
		invocation.invoke();
		System.out.println("----------");
		return null;
	}

}
