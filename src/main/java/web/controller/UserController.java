package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.entity.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String showAllUser(Model model) {
        model.addAttribute("allUser", userService.getAllUsers());
        return "all-user";
    }

    @GetMapping("/new")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "info";
    }
    @PostMapping ("/saveUser")
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.showId(id));
        return "edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.update(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/";
    }

}
