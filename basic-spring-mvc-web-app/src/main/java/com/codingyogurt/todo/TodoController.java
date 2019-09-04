package com.codingyogurt.todo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class TodoController {
	
	String username;
	
	@Autowired
	TodoService todoService;
	
	@RequestMapping(value="/todos", method = RequestMethod.GET)
	public String goToBukasan(ModelMap map){
		username = (String) map.get("username");
		map.addAttribute("todos", todoService.retrieveTodos(username));
		return "TodosView";
	}
	
	@RequestMapping(value = "/addtodo", method = RequestMethod.GET)
	public String goToAddTodo(){
		return "AddTodoView";
	}
	
	@RequestMapping(value = "/addtodo", method = RequestMethod.POST)
	public String processAddTodo(@RequestParam String desc){
		todoService.addTodo(username, desc, new Date(), false);	
		return "redirect:/todos";
	}
	
}
