package com.example.lab1.controller;

import com.example.lab1.Aspect.annotation.ExceptionLoggerAnnotation;
import com.example.lab1.Aspect.annotation.ExectutionTime;
import com.example.lab1.entity.User;
import com.example.lab1.entity.dto.UserDto;
import com.example.lab1.service.PostService;
import com.example.lab1.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/v1/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/")
    public List<UserDto> getUsers(){

        return userService.findAll().stream().map(u->userService.convertToDto(u)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ExectutionTime
    @ExceptionLoggerAnnotation
    public User getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable long id){
        return userService.deleteUserById(id);
    }

    @GetMapping("/filter/{num}")
    public List<User> findUserByPostNum(@PathVariable int num){
        return userService.userFilterByPostNum(num);
    }
}
