package com.example.security1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.security1.model.Users;
import com.example.security1.repository.UserRepository;

@Controller //  View를 리턴하겠다
public class IndexController {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	// localhost:8080/
	// localhost:8080
	@GetMapping({"","/"})
	public String index() {
		// 머스테치 기본폴더 src/main/resources/
		// 뷰리졸버 설정 : templates (prefix), .mustache (suffix) 생략가능!
		return "index";	// src/main/resources/templates/index.mustache
	}
	
	@GetMapping("/user")
	public @ResponseBody String user() {
		return "user";
	}
	
	@GetMapping("/admin")
	public @ResponseBody String admin() {
		return "admin";
	}
	
	@GetMapping("/manager")
	public @ResponseBody String manager() {
		return "manager";
	}
	
	// 추후 수정
	@GetMapping("/login")
	public String login() {
		return "loginForm";
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	@GetMapping("/joinForm")
	public String joinForm() {
		return "joinForm";
	}
	
	@PostMapping("/join")
	public String join(Users users) {
		System.out.println(users);
		users.setRole("ROLE_USER");
		String rawPassword = users.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		users.setPassword(encPassword);
		
		userRepository.save(users); // 회원가입 잘 됨. 비밀번호 : 1234 => 시큐리티로 로그인을 할 수 없음. 패스워드가 암호화되지 않았기 때문
		return "redirect:/loginForm";
	}
}