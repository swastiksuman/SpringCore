package com.springframework.didemo.examplebeans;

public class JMSBroker {
	private String user;
	private String password;
	private String url;
	private String envname;
	
	
	public String getEnvname() {
		return envname;
	}
	public void setEnvname(String envname) {
		this.envname = envname;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
