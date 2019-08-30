package com.codingyogurt;

public class IndexLoginService {
	public boolean verifyUser(String username, String password) {
		return username.equalsIgnoreCase("ryan") && password.equalsIgnoreCase("dummy");
	}
}
