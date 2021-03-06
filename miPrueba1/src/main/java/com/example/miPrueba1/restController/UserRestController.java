package com.example.miPrueba1.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.miPrueba1.entities.User;
import com.example.miPrueba1.repository.UserRepository;
import com.example.miPrueba1.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserRestController {
  // standard constructors
    @Autowired
    private  UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userService.findAll();
    }

    @PostMapping("/users")
    void addUser(@RequestBody User user) {
    	userService.save(user);
    }
}
