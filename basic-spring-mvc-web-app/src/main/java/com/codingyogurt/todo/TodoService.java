package com.codingyogurt.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<TodoItem> todos = new ArrayList<TodoItem>();
	private static int todoCount = 3;

	static {
		todos.add(new TodoItem(1, "ryan", "Learn Spring MVC", new Date(),
				false));
		todos.add(new TodoItem(2, "ryan", "Learn Struts", new Date(), false));
		todos.add(new TodoItem(3, "ryan", "Learn Hibernate", new Date(),
				false));
	} 
	
	public List<TodoItem> retrieveTodos(String user) {
		List<TodoItem> filteredTodos = new ArrayList<TodoItem>();
		for (TodoItem todo : todos) {
			if (todo.getUser().equals(user))
				filteredTodos.add(todo);
		}
		return filteredTodos;
	}
	
	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
		todos.add(new TodoItem(++todoCount, name, desc, targetDate, isDone));
		System.out.println("added new todo");
	}
	
	public void deleteTodo(int id) {
		Iterator<TodoItem> iterator = todos.iterator();
		while (iterator.hasNext()) {
			TodoItem todo = iterator.next();
			if (todo.getId() == id) {
				iterator.remove();
			}
		}
	}
	

}
