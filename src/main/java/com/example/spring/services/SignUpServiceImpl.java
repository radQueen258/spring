package com.example.spring.services;

import com.example.spring.dto.UserForm;
import com.example.spring.models.Role;
import com.example.spring.models.State;
import com.example.spring.models.User;
import com.example.spring.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SignUpServiceImpl implements SignUpService{

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SmsService smsService;

    @Autowired
    private MailService mailService;

    @Override
    public void addUser(UserForm form) {
        User user = User.builder()
                .email(form.getEmail())
                .password(passwordEncoder.encode(form.getPassword()))
                .firstName(form.getFirstname())
                .lastName(form.getLastname())
                .phone(form.getPhone())
                .state(State.NOT_CONFIRMED)
                .confirmed(UUID.randomUUID().toString())
                .role(Role.USER)
                .build();
        usersRepository.save(user);
        mailService.sendEmailForConfirm(user.getEmail(), user.getConfirmed());
        smsService.sendSms(form.getPhone(), "You registered!");
    }

    @Override
    public boolean confirmByGmail(String confirm) {
        User user = usersRepository.findByConfirmed(confirm).get();

        System.out.println("USER "+ user.getEmail());
        if (user != null) {
            user.setState(State.valueOf("CONFIRMED"));
            usersRepository.save(user);
            return true;
        }

        return false;
    }
}
