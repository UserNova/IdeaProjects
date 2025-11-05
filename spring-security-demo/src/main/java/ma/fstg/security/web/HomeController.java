package ma.fstg.security.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home"; // page Thymeleaf ou message simple
    }

    @GetMapping("/user/dashboard")
    public String userDashboard() {
        return "user-dashboard"; // page Thymeleaf ou message simple
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "admin-dashboard"; // page Thymeleaf ou message simple
    }

    //@GetMapping("/login")
    //public String loginPage() {
      //  return "login";
    //}
}
