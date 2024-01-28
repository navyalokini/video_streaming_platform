package com.netflixclone.Netflixcloneserver.repositories;

import com.netflixclone.Netflixcloneserver.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long>{
}
