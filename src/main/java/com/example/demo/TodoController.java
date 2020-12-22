package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class TodoController {

	private TodoRepository todoRep;

	@Autowired
	public TodoController(TodoRepository todoRep) {
		this.todoRep = todoRep;
	}

	@GetMapping(value = "/todo")
	public Iterable<Todo> list() {
		return todoRep.findAll();
	}

	@PostMapping(value = "/todo")
	public Todo save(@RequestBody Todo todo) {
//		Todo newTodo = new Todo(todo.getTitle(), todo.getCompleted());
		return todoRep.save(todo);
	}

	@PutMapping(value = "/todo")
	public Todo update(@RequestBody Todo todo) {
//		Todo todo = new Todo(id, title, completed);
		return todoRep.save(todo);
	}

	@DeleteMapping(value = "/todo/{id}")
	public void detele(@PathVariable long id) {
		todoRep.deleteById(id);
	}
	
	@PatchMapping(value = "/todoCheckAll/{completed}")
	public void checkAll(@PathVariable Boolean completed) {
		todoRep.checkAll(completed);
	}
	
	@PatchMapping(value = "/clearCompleted")
	public void clearCompleted() {
		todoRep.clearCompleted();
	}

}
