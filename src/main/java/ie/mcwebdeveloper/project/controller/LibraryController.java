package ie.mcwebdeveloper.project.controller;

import ie.mcwebdeveloper.project.models.Member;
import ie.mcwebdeveloper.project.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class LibraryController {
    @Autowired
    MemberRepository repository;
    // Index
    @GetMapping("/")
    public String getIndex() {
        return "index.html";
    }
    // Browse
//    @GetMapping("/browse")
//    public String getBrowse() {
//        return "browse.html";
//    }
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
    @GetMapping("/search")
    public String getSearch() {
        return "search.html";
    }
    @GetMapping("/profile/{id}")
    public String profile(@PathVariable String id, Model model){
        long i = Long.parseLong(id);
        Member member = repository.findById(i);
        model.addAttribute("member", member);
        return "profile.html";
    }
}