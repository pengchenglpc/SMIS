package com.smis.action.base;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import net.sf.json.JSON;

public class BaseAction implements SessionAware, ServletRequestAware, ServletResponseAware  {
	protected Map<String, Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	protected void outJSON(JSON json) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(json.toString());
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
