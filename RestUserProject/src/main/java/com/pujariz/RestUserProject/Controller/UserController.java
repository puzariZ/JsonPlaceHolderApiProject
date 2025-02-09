package com.pujariz.RestUserProject.Controller;

import com.pujariz.RestUserProject.Entity.User;
import com.pujariz.RestUserProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id){
        return userService.getUerById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable long id, @RequestBody User userDetails){
        return userService.updateUserById(id, userDetails);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> patchUserById(@PathVariable long id, @RequestBody User userDetails){
        return userService.patchUserById(id, userDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable long id){
        return userService.deleteUser(id);
    }
}
