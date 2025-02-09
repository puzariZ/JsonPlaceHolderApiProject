package com.pujariz.RestUserProject.Controller;

import com.pujariz.RestUserProject.DTO.UserDTO;
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
    private UserService userService;

//    @GetMapping
//    public List<User> getAllUsers(){
//        return userService.getAllUser();
//    }

    // Get all users with their posts
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable long id) {
        UserDTO userDTO = userService.getUserById(id);
        return ResponseEntity.ok(userDTO);
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
