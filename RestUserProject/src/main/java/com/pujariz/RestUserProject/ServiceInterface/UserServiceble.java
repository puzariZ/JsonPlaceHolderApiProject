package com.pujariz.RestUserProject.ServiceInterface;

import com.pujariz.RestUserProject.DTO.UserDTO;
import com.pujariz.RestUserProject.Entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserServiceble {

    //Get all users
    public List<UserDTO> getAllUsers();

    //Post
    public User createUser(@RequestBody User user);

    //Get{id}
    public UserDTO getUserById(@PathVariable long userId);


    //Put
    public ResponseEntity<User> updateUserById(@PathVariable long id, @RequestBody User userDetails);

    //Patch
    public ResponseEntity<User> patchUserById(@PathVariable long id, @RequestBody User userUpdates);

    //Delete
    public ResponseEntity<Object> deleteUser(@PathVariable long id);

}
