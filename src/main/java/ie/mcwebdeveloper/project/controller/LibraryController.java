package ie.mcwebdeveloper.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibraryController {

    // Index
    @GetMapping("/")
    public String getIndex() {
        return "index.html";
    }
    // Browse
    @GetMapping("/browse")
    public String getBrowse() {
        return "browse.html";
    }
    // View Library (Show)
//    @GetMapping("/browse/{id}")
//    public String showLibrary() {
//        return "browse.html";
//    }
    // Login
    @GetMapping("/login")
    public String getLogin() {
        return "login.html";
    }
    // Signup
    @GetMapping("/signup")
    public String getSignup() {
        return "signup.html";
    }

}