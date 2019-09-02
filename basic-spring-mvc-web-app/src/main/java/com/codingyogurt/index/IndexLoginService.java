package com.codingyogurt.index;

import org.springframework.stereotype.Service;

@Service
public class IndexLoginService {
	public boolean verifyUser(String username, String password) {
		return username.equalsIgnoreCase("ryan") && password.equalsIgnoreCase("dummy");
	}
}
