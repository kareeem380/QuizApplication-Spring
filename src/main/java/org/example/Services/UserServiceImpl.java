package org.example.Services;

import org.example.Entities.User;
import org.example.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository repositry;
    @PostMapping("/user")
    public  User saveUser(@RequestBody User user){
        return repositry.save(user);
    };
    @PutMapping("/user")
    public  User updateUser(@RequestBody User user){
        return repositry.save(user);
    };
    @DeleteMapping("/user/{id}")
    public  void deleteUser(@PathVariable Long id){
        repositry.deleteById(id);
    };
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id){
        return repositry.findById(id).orElse(null);
    };
    @GetMapping("/users")
    public  List <User> getAllUsers(){
        return repositry.findAll();
    };
    @DeleteMapping("/user")
    public  void deleteAllUsers(){
        repositry.deleteAll();
    };
}