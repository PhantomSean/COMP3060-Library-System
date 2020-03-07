package ie.mcwebdeveloper.project.controller;

import ie.mcwebdeveloper.project.models.User;
import ie.mcwebdeveloper.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LibraryController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String getLanding(User theUser, Model model) {
        model.addAttribute("currUser", theUser);
        return "index.html";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login.html";
    }

    @PostMapping("/login")
    public String login(User theUser, Model model) {
        boolean username, password;
        String message = null;
        username = userRepository.existsByUsername(theUser.getUsername());
        password = userRepository.existsByPassword(theUser.getPassword());

        if(username != true || password != true) {
            message = "Invalid username or password";
            model.addAttribute("message", message);
            return "login.html";
        }
        else {
            return "redirect:";
        }
    }

    @GetMapping("/signup")
    public String getSignup(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signup.html";
    }

    @PostMapping("/signup")
    public String signup(User theUser, Model model) {
        String message;

        if(userRepository.existsByUsername(theUser.getUsername())) {
            message = "Username taken.";
            model.addAttribute("message", message);
            return "redirect:/signup";
        }

        userRepository.save(theUser);

        return "redirect:";
    }

    @GetMapping("/user")
    public String getUser() {
        return "user/index.html";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "admin/index.html";
    }

    @GetMapping("/search")
    public String getSearch() {
        return "search.html";
    }

    //    @PostMapping("/")
//    public String loginMember() {
//        return "/";
//    }
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

    @GetMapping("/user/profile/{id}")
    public String profile(@PathVariable String id, Model model){
        long i = Long.parseLong(id);
        User user = userRepository.findById(i);
        model.addAttribute("currUser", user);
        return "profile.html";
    }
}