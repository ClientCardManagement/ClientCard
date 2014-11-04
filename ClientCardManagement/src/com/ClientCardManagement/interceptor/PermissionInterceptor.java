package com.ClientCardManagement.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class PermissionInterceptor implements Interceptor {


	private static final long serialVersionUID = 569135357740724712L;

	

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		Object username = ActionContext.getContext().getSession().get(
				"username");
		if (username != null) {
			return invocation.invoke();
		}
		return "not-login";
	}

}
