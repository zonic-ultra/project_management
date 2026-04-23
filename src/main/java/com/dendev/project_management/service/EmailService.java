package com.dendev.project_management.service;

public interface EmailService {
    void sendEmail(String to, String subject, String text);
}
