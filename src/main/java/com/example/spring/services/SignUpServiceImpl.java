package com.example.spring.services;

import com.example.spring.dto.UserForm;
import com.example.spring.models.User;
import com.example.spring.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignUpServiceImpl implements SignUpService{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void addUser(UserForm form) {
        User user = User.builder()
                .email(form.getEmail())
                .password(form.getPassword())
                .build();
        usersRepository.save(user);
    }
}
