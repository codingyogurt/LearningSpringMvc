package com.codingyogurt.todo;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
	public String goToBukasan(ModelMap model){
		
		username = (String) model.get("username");
		model.addAttribute("todos", todoService.retrieveTodos(username));
		return "TodosView";
	}
	
	@RequestMapping(value = "/addtodo", method = RequestMethod.GET)
	public String goToAddTodo(ModelMap model){
		model.addAttribute("todoItem", new TodoItem()); 
		return "AddTodoView";
	}
	
	@RequestMapping(value = "/addtodo", method = RequestMethod.POST)
	public String processAddTodo(ModelMap model, @Valid TodoItem todo, BindingResult result){
		
		if(result.hasErrors()) { 
			return "AddTodoView";
		}
		
		todoService.addTodo(username, todo.getDesc(), new Date(), false);	
		model.clear();
		return "redirect:/todos";
	}
	
	@RequestMapping(value = "/deletetodo", method = RequestMethod.GET)
	public String deleteTodo(ModelMap model, @RequestParam int id){
		model.clear();
		todoService.deleteTodo(id);
		return "redirect:/todos";
	}
	
	// redirection to update todo
	@RequestMapping(value = "/updatetodo", method = RequestMethod.GET)
	public String updateTodo(ModelMap model, @RequestParam int id){
		model.addAttribute("todoItem", todoService.retrieveTodo(id));
		return "AddTodoView";
	}
	
	// sending post method to /updatetodo url
	@RequestMapping(value = "/updatetodo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid TodoItem todoItem, BindingResult result){
		if(result.hasErrors()) {
			return "AddTodoView";
		}
		todoItem.setUser((String) model.get("username"));
		todoItem.setTargetDate(new Date());
		todoService.updateTodo(todoItem);
		
		return "redirect:/todos";
	}
	
	
	
}
