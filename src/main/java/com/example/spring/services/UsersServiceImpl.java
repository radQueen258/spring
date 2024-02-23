package com.example.spring.services;

import com.example.spring.dto.UserDto;
import com.example.spring.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.spring.dto.UserDto.userList;

@Component
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<UserDto> getAllUsers() {
        return userList(usersRepository.findAll());
    }
}
