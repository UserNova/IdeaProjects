package ma.fstg.security.spring_security_jpa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    // Page de login
    @GetMapping("/login")
    public String login() {
        return "login"; // Thymeleaf va chercher login.html dans /templates
    }

    // Page après login
    @GetMapping("/home")
    public String home() {
        return "home"; // Thymeleaf va chercher home.html dans /templates
    }
    @GetMapping("/logout")
    public String logout() {
        return "login"; // Thymeleaf va chercher login.html dans /templates
    }
}
