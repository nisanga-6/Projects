package com.example.Techie.YoutubeClone.Service;

import com.example.Techie.YoutubeClone.Model.Video;
import com.example.Techie.YoutubeClone.Repository.videoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class VideoService {

   private final S3Service s3Service;
   private final videoRepository videoRepository;

    public void uploadVedio(MultipartFile multipartFile){

    String vedioURL =   s3Service.uploadFile(multipartFile);

    var vedio = new Video();
    vedio.setVedioURL(vedioURL);
    videoRepository.save(vedio);


    }
}
