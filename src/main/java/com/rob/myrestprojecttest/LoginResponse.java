package com.rob.myrestprojecttest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="loginResponse")
public class LoginResponse {
	
	private String name;
	private String loginResult;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginResult() {
		return loginResult;
	}
	public void setLoginResult(String loginResult) {
		this.loginResult = loginResult;
	}
}
