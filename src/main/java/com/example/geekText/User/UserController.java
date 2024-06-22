package com.example.geekText.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepo;

    @Autowired
    public UserController(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    @PostMapping("/adduser")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        try {
            userRepo.insertUser(new User(user.getId()));
            return new ResponseEntity<>("User was created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getusers")
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) long id) {
        try {

            List<User> users = new ArrayList<>();

            if (id != 0) {
                users.addAll(userRepo.selectAllUsers());
                return new ResponseEntity<>(HttpStatus.OK);
            }

            users.addAll(userRepo.selectAllUsers());

            if (users.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(users, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

