package com.codingyogurt.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@RequestMapping(value="/todos", method = RequestMethod.GET)
	public String goToBukasan(ModelMap map){
		map.addAttribute("todos", todoService.retrieveTodos("in28Minutes"));
		map.addAttribute("username", todoService.retrieveTodos("in28Minutes").get(0).getUser());
		return "TodosView";
	}
	
}
