package com.example.Techie.YoutubeClone.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Document(value="vedio")//MongoDB Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video {

    private String id;
    private String title;
    private String description;
    private String userId;
    private Integer likes;
    private Integer disLikes;
    private Set<String>tags;
    private String vedioURL;
    private vedioStatus vedioStatus;
    private Integer viewCount;
    private String thumbnailURL;
    private List<Comment> comments;


}
