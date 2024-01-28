package com.netflixclone.Netflixcloneserver.repositories;

import com.netflixclone.Netflixcloneserver.models.Video;
import org.springframework.data.repository.CrudRepository;

public interface VideoRepository extends CrudRepository<Video,Long> {
}
