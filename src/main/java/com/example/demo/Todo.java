package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Todo {

	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private Boolean completed;

	public Todo() {
	}

	public Todo(String title, Boolean completed) {
		this.title = title;
		this.completed = completed;
	}

	public Todo(Long id, String title, Boolean completed) {
		this.id = id;
		this.title = title;
		this.completed = completed;
	}

}
