package com.example.ms1.siteuser;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/signup")
    public String signup(UserCreateForm userCreateForm){

        return "signup_form";
    }


    @PostMapping("/signup")
    public String signup(@Valid UserCreateForm userCreateForm , BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return  "signup_form";
        }
        userService.create(userCreateForm.getLoginId(), userCreateForm.getPassword(), userCreateForm.getNickname(), userCreateForm.getPassword());

        return "redirect:/";
    }
}
