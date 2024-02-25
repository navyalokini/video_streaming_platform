package com.example.to_do_app.repositories;


import com.example.to_do_app.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {

         Optional<User> findByUsername(String username);
}
