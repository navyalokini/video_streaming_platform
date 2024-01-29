package com.netflixclone.Netflixcloneserver.repositories;

import com.netflixclone.Netflixcloneserver.models.UserData;
import org.springframework.data.repository.CrudRepository;

public interface UserDataRepository extends CrudRepository<UserData,Long> {
}
