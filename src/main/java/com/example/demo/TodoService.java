package com.example.demo;

import org.springframework.stereotype.Service;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Service
public class TodoService {

	@Getter
	@AllArgsConstructor
	public enum CommonResponse {
		SUCCESS(0, "성공하였습니다."),
		FAIL(-1, "실패하였습니다.");
		
		int code;
		String msg;
		
	}
}
