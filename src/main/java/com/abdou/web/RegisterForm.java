package com.abdou.web;




public class RegisterForm {
private String username;
private String password;
private String repass;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRepass() {
	return repass;
}
public void setRepass(String repass) {
	this.repass = repass;
}
public RegisterForm(String username, String password, String repass) {
	super();
	this.username = username;
	this.password = password;
	this.repass = repass;
}
public RegisterForm() {
	super();
	// TODO Auto-generated constructor stub
}

}
