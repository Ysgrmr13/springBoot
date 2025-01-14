package org.springcourse.springboot.controller;

import org.springcourse.springboot.model.User;
import org.springcourse.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users"; // Убедитесь, что это имя вашего шаблона Thymeleaf
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/updateUser")
    public String updateUserForm(@RequestParam Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "updateUser"; // Убедитесь, что это имя вашего шаблона Thymeleaf
    }

    @PostMapping("/updateUser")
    public String updateUser(@RequestParam Long id, @RequestParam String name, @RequestParam String email) {
        User user = userService.findById(id);
        user.setName(name);
        user.setEmail(email);
        userService.update(user);
        return "redirect:/users";
    }
}
