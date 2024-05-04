package com.example.Techie.YoutubeClone.Controllers;

import com.example.Techie.YoutubeClone.Service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping( "/api/videos")
@RequiredArgsConstructor
public class videoController {

    private final VideoService videoService;

@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public void uploadVideo(@RequestParam("file")MultipartFile file){

    videoService.uploadVedio(file);
}
}
