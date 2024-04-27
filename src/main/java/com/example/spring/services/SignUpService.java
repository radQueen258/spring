package com.example.spring.services;

import com.example.spring.dto.UserForm;

public interface SignUpService {
     void addUser (UserForm form);

    boolean confirmByGmail(String confirm);
}
