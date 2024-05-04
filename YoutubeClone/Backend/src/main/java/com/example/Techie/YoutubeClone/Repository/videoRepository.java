package com.example.Techie.YoutubeClone.Repository;

import com.example.Techie.YoutubeClone.Model.Video;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface videoRepository extends MongoRepository<Video,String> {
}
