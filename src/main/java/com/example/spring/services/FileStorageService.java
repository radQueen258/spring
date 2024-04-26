package com.example.spring.services;

import com.example.spring.dto.FileForm;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@Component
public interface FileStorageService {
    String saveFile(MultipartFile file, FileForm fileForm);

    void writeFileToResponse(String fileName, HttpServletResponse response);
}
