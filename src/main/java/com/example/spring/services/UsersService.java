package com.example.spring.services;

import com.example.spring.dto.UserDto;

import java.util.List;

public interface UsersService {

    List<UserDto> getAllUsers();
}
