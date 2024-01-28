package com.netflixclone.Netflixcloneserver.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserData {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

   private String email;
   


}
