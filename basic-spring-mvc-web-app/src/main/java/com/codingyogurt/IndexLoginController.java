package com.codingyogurt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexLoginController {
	
	@RequestMapping(value="/bukasan", method = RequestMethod.GET)
	public String goToBukasan(){
		return "IndexView";
	}
	
	@RequestMapping(value="/bukasan", method = RequestMethod.POST)
	public String goToWelcome(
			@RequestParam String txtUsername,
			@RequestParam String txtPassword,
			ModelMap map) {
		
		IndexLoginService indexLoginService = new IndexLoginService();
		
		if(!indexLoginService.verifyUser(txtUsername, txtPassword)) {
			map.put("indexMessage","Error Logging in.");
			return "IndexView";
		}
				
		map.put("username",txtUsername);
		return "Welcome";
	}
	
	
}
