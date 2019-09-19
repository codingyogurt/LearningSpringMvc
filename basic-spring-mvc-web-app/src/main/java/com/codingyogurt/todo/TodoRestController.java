package com.codingyogurt.todo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoRestController {
	
	@Autowired
	TodoService service;
	
	@RequestMapping(value = "/listtodo", method = RequestMethod.GET)
	public List<TodoItem> restAllTodos() {
		List<TodoItem> todos = service.retrieveTodos("ryan");
		return todos;
	}
	
	@RequestMapping(value = "/listtodo/{id}", method = RequestMethod.GET)
	public TodoItem restAllTodos(@PathVariable int id) {
		TodoItem todos = service.retrieveTodo(id);
		return todos;
	}
	
}
