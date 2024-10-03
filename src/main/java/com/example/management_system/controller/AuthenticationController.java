package com.example.management_system.controller;

import com.example.management_system.model.User;
import com.example.management_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 로그인 페이지 표시
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // login.html 페이지로 이동
    }

    // 회원가입 페이지 표시
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // register.html 페이지로 이동 (회원가입 템플릿)
    }

    // 회원가입 처리
    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password, @RequestParam String role) {
        // 새 사용자 생성 및 저장
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password)); // 비밀번호 암호화
        newUser.setRole(role); // 역할 설정 (ROLE_USER 등)
        userRepository.save(newUser);
        return "redirect:/login"; // 회원가입 후 로그인 페이지로 리다이렉트
    }
}