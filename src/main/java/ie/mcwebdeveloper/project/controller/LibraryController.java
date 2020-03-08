package ie.mcwebdeveloper.project.controller;

import ie.mcwebdeveloper.project.UserSession;
import ie.mcwebdeveloper.project.models.User;
import ie.mcwebdeveloper.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
public class LibraryController {

    @Autowired
    private UserSession userSession;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String getLanding(Model model) {
        model.addAttribute("title", "LMS - Home");
        model.addAttribute("user", userSession.getUser());
        return "index.html";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login.html";
    }

    @PostMapping("/login")
    public void login(String username, String password, HttpServletResponse response, Model model) throws Exception {
        String message = null;
        Optional<User> user = userRepository.findByUsernameAndPassword(username, password);
        if(user.isPresent()) {
            userSession.setUser(user.get());
            response.sendRedirect("/");
        } else {
            userSession.setLoginFailed(true);
            model.addAttribute("message", message);
            response.sendRedirect("/login");
        }
    }

    @GetMapping("/logout")
    public void logout(HttpServletResponse response, Model model) throws  Exception {
        userSession.setUser(null);
        model.addAttribute("logoutMessage", "You have logged out successfully.");
        response.sendRedirect("/");
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
        if(userRepository.existsByUsername(userSession.getUser().getUsername())) {
            model.addAttribute("message", "Username taken.");
            return "redirect:/signup";
        }
        userRepository.save(theUser);
        return "redirect:";
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
    public String getProfile(@PathVariable String id, Model model){
        if(userSession.getUser() == null) {
            return "redirect:/login";
        } else {
            model.addAttribute("title", "LMS - Profile");
            model.addAttribute("user", userSession.getUser());
            return "profile.html";
        }
    }

    @PostMapping("/user/profile/{id}")
    public String changeProfile(@PathVariable String id, User theUser, Model model) {
        boolean usernameTaken = false, emailTaken = false;
        long i = Long.parseLong(id);
        if(userRepository.existsByUsername(theUser.getUsername()))
            usernameTaken = true;
        if(userRepository.existsByEmail(theUser.getEmail()))
            emailTaken = true;

        if(!usernameTaken && !emailTaken) {
            Optional<User> userToUpdate = userRepository.findById(i);
            userRepository.updateUser(theUser.getUsername(), theUser.getFirstname(), theUser.getLastname(), theUser.getEmail(), theUser.getPassword(), i);
            model.addAttribute("success", true);
            return "redirect:/user/profile/" + id;
        } else {
            model.addAttribute("success", false);
            return "redirect:/user/profile/" + id;
        }
    }
}