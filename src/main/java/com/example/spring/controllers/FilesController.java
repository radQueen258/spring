package com.example.spring.controllers;

import com.example.spring.dto.FileForm;
import com.example.spring.models.FileInfo;
import com.example.spring.repositories.FilesRepository;
import com.example.spring.services.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class FilesController {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private FilesRepository filesRepository;

    @GetMapping("/files/upload")
    public String getFilesUploadPage () {
        return "file_upload_page";
    }

    @PostMapping("/files")
    public ResponseEntity<String> fileUpload(@RequestParam("file")MultipartFile file, FileForm fileForm) {
        String filePath = fileStorageService.saveFile(file, fileForm);
        return ResponseEntity.ok()
                .body(filePath);
    }

    @GetMapping("/files/{file-name:.+}")
    public void getFile(@PathVariable("file-name") String fileName, HttpServletResponse response) {
        fileStorageService.writeFileToResponse(fileName, response);

    }

    @GetMapping("/posts")
    public String getAllPosts (Model model) {
        List<FileInfo> posts = filesRepository.findAll();
        model.addAttribute("posts", posts);
        return "posts_page";
    }
}
