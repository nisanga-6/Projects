package com.example.Techie.YoutubeClone.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Document(value="user")//class is mapping to collection in the database
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String fullname;
    private Set<String> subscribedToUsers;
    private Set<String> subscribers;
    private List<String> vedioHistory;
    private Set<String> likedVedios;
    private Set<String> dislikedVedios;
}
