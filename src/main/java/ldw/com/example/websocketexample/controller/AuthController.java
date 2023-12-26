package ldw.com.example.websocketexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/auth/login")
    public String loginForm(){
        return "auth/LoginForm";
    }
}
