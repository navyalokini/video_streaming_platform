package com.netflixclone.Netflixcloneserver.controllers;

import com.netflixclone.Netflixcloneserver.models.Video;
import com.netflixclone.Netflixcloneserver.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/admin/video")
public class VideoController {
    @Autowired

    private VideoRepository videoRepository;
    @PostMapping("/save-video")
    public String saveVideo(@RequestBody Video video){
        LocalDateTime CURRENT_DATE = LocalDateTime.now();
        String stringifiesDate = CURRENT_DATE.toString();
        System.out.println(stringifiesDate);
        video.setCreatedDate(stringifiesDate);
        video.setUpdatedDate(stringifiesDate);
        System.out.println("videoObject"+video);
        videoRepository.save(video);
        return "video saved successfully";


    }
}
