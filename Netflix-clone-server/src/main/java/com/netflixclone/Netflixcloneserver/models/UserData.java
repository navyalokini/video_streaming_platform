package com.netflixclone.Netflixcloneserver.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;



@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserData {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

   private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @ElementCollection(targetClass = String.class,fetch=FetchType.EAGER)
    private List<String> previouslyWatchedVideos;


}
