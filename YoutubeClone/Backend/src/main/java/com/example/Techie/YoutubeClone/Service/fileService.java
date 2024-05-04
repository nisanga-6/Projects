package com.example.Techie.YoutubeClone.Service;

import org.springframework.web.multipart.MultipartFile;

public interface fileService {
    String uploadFile(MultipartFile file);
}
