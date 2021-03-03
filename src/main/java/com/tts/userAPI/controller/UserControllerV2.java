package com.tts.userAPI.controller;

import com.tts.userAPI.model.UserV1;
import com.tts.userAPI.model.UserV2;
import com.tts.userAPI.repository.UserRepositoryV2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequestMapping("/v2")
@Api(value="users", description = "Operations pertaining to users")
@RestController
public class UserControllerV2 {


    UserRepositoryV2 userRepositoryV2;

    public UserControllerV2(UserRepositoryV2 userRepositoryV2) {
        this.userRepositoryV2 = userRepositoryV2;
    }

    @GetMapping("/item/all")
    public ResponseEntity<List<UserV2>> getAllUsers() {
        return new ResponseEntity<>(new ArrayList<UserV2>(), HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "There is no longer the ability to get all users at once"),
            @ApiResponse(code = 401, message = "You are not authorized to view the users")
    })

    @ApiOperation(value = "Get all users and state", response = UserV2.class,
            responseContainer = "List")
    @GetMapping("all")
    public UserV2 getUsers(@PathVariable(value="state") String state) {
        return userRepositoryV2.findByState(state);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved user by id"),
            @ApiResponse(code = 401, message = "You are not authorized to view user or id")
    })
    @ApiOperation(value = "Get user by id", response = UserV2.class,
            responseContainer = "id")
    @GetMapping("users/{id}")
    public Optional<UserV2> getUserById(@PathVariable(value="id") Long id) {
        return userRepositoryV2.findById(id);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created a new user"),
            @ApiResponse(code = 401, message = "You are not authorized to create users")
    })
    @ApiOperation(value = "Create new user", response = UserV2.class,
            responseContainer = "save")
    @PostMapping("user")
    public void createUser(@RequestBody UserV2 user) {
        userRepositoryV2.save(user);
    }
    @ApiOperation(value = "Create user", response = UserV1.class,
            responseContainer = "id")
    @PutMapping("user/{id}")
    public void createUser(@PathVariable(value="id") Long id, @RequestBody UserV2 user) {
        userRepositoryV2.save(user);
    }
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted a user"),
            @ApiResponse(code = 401, message = "You are not authorized to delete users")
    })
    @ApiOperation(value = "Delete user", response = UserV2.class,
            responseContainer = "deleteById")
    @DeleteMapping("user/{id}")
    public void createUser(@PathVariable(value="id") Long id) {
        userRepositoryV2.deleteById(id);
    }

//    @GetMapping("users")
//    public List<User> getUsers(@RequestParam(value="state", required=false) String state) {
//        if (state != null) {
//            return (List<User>) userRepository.findByState(state);
//        }
//        return (List<User>) userRepository.findAll();
//    }

//    @PostMapping("add")
//    public ResponseEntity<Void> createUser(@RequestBody @Valid User user, BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors()) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        userRepository.save(user);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//
//    @GetMapping("{id}")
//    public ResponseEntity<User> getUser(@PathVariable Long id) {
//        Optional<User> user = userRepository.findById(id);
//
//        if (user.equals("")) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity<>(user.get(), HttpStatus.OK);
//    }
}

