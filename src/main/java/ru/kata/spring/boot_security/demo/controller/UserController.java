package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;


@Controller
@RequestMapping("/")
public class UserController {

    private final ru.kata.spring.boot_security.demo.service.UserService userService;
//    private final UserService userService;

    @Autowired
    UserController(ru.kata.spring.boot_security.demo.service.UserService userService) {
        this.userService = userService;
    }

//    @Autowired
//    UserController(UserService userService) {
//        this.userService = userService;
//    }

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/user-create")
    public String createNewUser(Model model) {
        model.addAttribute("user", new User());
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable Long id, Model model) {
        model.addAttribute("update", userService.getUserById(id));
        return "updateUser";
    }

    @PostMapping("/updateUser/{getId}")
    public String saveUpdateUser(@PathVariable Long getId, @ModelAttribute("user") User user) {
        user.setId(getId);
        userService.updateUser(user);
        return "redirect:/";
    }


}
