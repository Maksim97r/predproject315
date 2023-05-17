package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api/admin/users")
public class AdminRESTController {

    private final UserService userService;

    @Autowired
    public AdminRESTController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        ResponseEntity.BodyBuilder builder = ResponseEntity.ok();
        List<User> users = userService.findAll();
        return builder.body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        ResponseEntity.BodyBuilder builder = ResponseEntity.ok();
        User user = userService.getUserById(id);
        return builder.body(user);
    }

    @PostMapping
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        ResponseEntity.BodyBuilder builder = ResponseEntity.ok();
        userService.saveUser(user);
        return builder.body(user);
    }

    @PatchMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        ResponseEntity.BodyBuilder builder = ResponseEntity.ok();
        userService.updateUser(user);
        return builder.body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
        ResponseEntity.BodyBuilder builder = ResponseEntity.ok();
        userService.deleteUserById(id);
       return builder.body(HttpStatus.OK);
    }
}
