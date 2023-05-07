package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;

    @Autowired
    public AdminController(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String getAdminPage(Model model, Principal principal) {
        model.addAttribute("admin", userService.findByName(principal.getName()));
        model.addAttribute("user", new User());

        model.addAttribute("users", userService.findAll());
        model.addAttribute("roles", roleService.getAllRoles());

        return "admin";
    }
}
//
//    @PostMapping("/editUser/{id}")
//    public String saveUpdateUser(@ModelAttribute("user") User user) {
//        userService.updateUser(user);
//        return "redirect:/admin";
//    }
//
//    @PostMapping("/add")
//    public String createUser(@ModelAttribute("user") User user) {
//        userService.saveUser(user);
//        return "redirect:/admin";
//    }
//
//    @GetMapping("/deleteUser/{id}")
//    public String deleteUser(@PathVariable Long id) {
//        userService.deleteUserById(id);
//        return "redirect:/admin";
//    }
//}
