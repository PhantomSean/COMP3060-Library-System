package ie.mcwebdeveloper.project.controller;

import ie.mcwebdeveloper.project.UserSession;
import ie.mcwebdeveloper.project.models.Book;
import ie.mcwebdeveloper.project.models.User;
import ie.mcwebdeveloper.project.repositories.BookRepository;
import ie.mcwebdeveloper.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LibraryController {

    @Autowired
    private UserSession userSession;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/")
    public String getLanding(Model model) {
        model.addAttribute("title", "LMS - Home");
        model.addAttribute("user", userSession.getUser());
        return "index.html";
    }

    @GetMapping("/search")
    public String getSearch(Model model) {
        model.addAttribute("title", "LMS - Search");
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
        model.addAttribute("title", "LMS - Profile");
        if(userSession.getUser() == null) {
            return "redirect:/login";
        } else {
            model.addAttribute("title", "LMS - Profile");
            model.addAttribute("user", userSession.getUser());
            return "profile.html";
        }
    }

    @PostMapping("/user/profile")
    public String changeProfile(User theUser, Model model) {
        User currUser = userSession.getUser();
        boolean usernameTaken = false, emailTaken = false;
        if(userRepository.existsByUsername(theUser.getUsername()))
            usernameTaken = true;
        if(userRepository.existsByEmail(theUser.getEmail()))
            emailTaken = true;

        if(!usernameTaken && !emailTaken) {
            userRepository.updateUser(theUser.getUsername(), theUser.getFirstname(), theUser.getLastname(), theUser.getEmail(), theUser.getPassword(), currUser.getId());
            model.addAttribute("success", true);
            return "redirect:/user/profile/" + currUser.getId();
        } else {
            model.addAttribute("success", false);
            return "redirect:/user/profile/" + currUser.getId();
        }
    }

    @GetMapping("/admin/manage/{id}")
    public String getManage(@PathVariable String id, Model model) {
        if(userSession.getUser() == null) {
            return "redirect:/login";
        } else {
            model.addAttribute("title", "LMS - Manage");
            model.addAttribute("user", userSession.getUser());
            return "manage.html";
        }
    }

    @PostMapping("/admin/manage")
    public String addBook(Book theBook, Model model) {
        bookRepository.save(theBook);
        return "redirect:/admin/manage/" + userSession.getUser().getId();
    }

    @GetMapping("/admin/manage/view-members")
    public String viewMembers(Model model) {
        if(userSession.getUser() == null) {
            return "redirect:/login";
        } else {
            model.addAttribute("title", "LMS - View Members");
            List<User> users = userRepository.findAll();
            model.addAttribute("users", users);
            return "viewmembers.html";
        }
    }

    @GetMapping("admin/manage/view-books")
    public String viewBooks(Model model) {
        if(userSession.getUser() == null) {
            return "redirect:/login";
        } else {
            model.addAttribute("title", "LMS - View Books");
            List<Book> books = bookRepository.findAll();
            model.addAttribute("books", books);
            return "viewbooks.html";
        }
    }
}