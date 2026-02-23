package com.simonpeg.controller;

import com.simonpeg.dto.AccountUpsertDto;
import com.simonpeg.service.abs.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/loginForm")
    public String loginForm(){
        return "account/loginForm";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "account/access-denied";
    }

    @GetMapping("/loginFailed")
    public String loginFailed(){
        return "account/loginFailed";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("dto", new AccountUpsertDto());
        return "account/register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("dto") AccountUpsertDto dto,
                           BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("dto", dto);
            return "account/register";
        }else{
            accountService.registerAccount(dto);
            return "redirect:/account/loginForm";
        }
    }
}
