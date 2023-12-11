package com.example.demo.controller;

import com.example.demo.dto.AccountDto;
import com.example.demo.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/Account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/register")
    public String register(@ModelAttribute AccountDto dto){
        accountService.createId(dto);
        return "login";
    }
    
    @PostMapping("/login")
    public String login(@ModelAttribute AccountDto dto){
        return accountService.checkId(dto) ? "index" : "register";
    }

    @GetMapping("/login")
    public String registerPage(){
        return "register";
    }

}
