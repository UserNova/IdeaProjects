package ma.ens.security.spring_jwt_api.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class TestController {


    @GetMapping("/user/profile")
    public String userProfile() {
        return "This is a USER profile endpoint";
    }


    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "This is an ADMIN dashboard endpoint";
    }
}
