package com.example.spring.services;

public interface MailService {
    void sendEmailForConfirm(String email, String code);
}
