package com.example.lab1.service;

import com.example.lab1.entity.User;
import com.example.lab1.entity.dto.UserDto;
import com.example.lab1.repo.PostRepo;
import com.example.lab1.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private PostRepo postRepository;
    @Autowired
    private ModelMapper modelMapper;

    public User addUser(User user){
        return userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User getUserById(long id){
        return userRepository.findById(id).get();
    }

    public String deleteUserById(long id){
        userRepository.deleteById(id);
        return "user that has id: "+id+" is deleted";
    }

    public List<User> userFilterByPostNum(int num){
        return userRepository.findUserWithPosts(num);
    }

    public UserDto convertToDto(User user){
        UserDto userDto = modelMapper.map(user,UserDto.class);
        return userDto;
    }

}
