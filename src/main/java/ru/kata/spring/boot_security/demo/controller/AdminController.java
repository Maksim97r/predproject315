package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;
    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
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

    @PostMapping("/editUser/{id}")
    public String saveUpdateUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.updateUser(user);
        return "redirect:/admin";
    }

//    @GetMapping
//    public String getAdmin(Model model, Principal principal, Role role) {
//        User user = userService.findByName(principal.getName());
//        model.addAttribute("admin", user);
//
//        model.addAttribute("role", role);
//        model.addAttribute("users", userService.findAll());
//        return "admin";
//    }

//    @GetMapping("/user-create")
//    public String createNewUser(Model model) {
//        model.addAttribute("user", new User());
//        return "user-create";
//    }

//    @PostMapping("/user-create")
//    public String createUser(@ModelAttribute("user") User user) {
//        userService.saveUser(user);
//        return "redirect:/admin";
//    }
//
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }

//    @GetMapping("/updateUser/{id}")
//    public String updateUser(@PathVariable Long id, Model model) {
//        model.addAttribute("update", userService.getUserById(id));
//        return "updateUser";
//    }




//    @PostMapping(value = "/edit/{id}")
//    public String editUsers(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
//        userService.updateUser(user);
//        return "redirect:/admin";
//    }
}
