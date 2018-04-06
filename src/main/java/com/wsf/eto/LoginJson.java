package com.wsf.eto;

public class LoginJson {
	public LoginJson(){
		super();
		
	}
	public LoginJson(String res, String err) {
		super();
		this.err = err;
		this.res = res;
	}
	public String err;
	public String res;
	public String getErr() {
		return err;
	}
	public void setErr(String err) {
		this.err = err;
	}
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}
	
}
