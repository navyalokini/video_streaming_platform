package com.example.to_do_app.repositories;

import com.example.to_do_app.models.UserData;
import org.springframework.data.repository.CrudRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

public interface UserDataRepository extends CrudRepository<UserData, Long> {


    ArrayList<Optional <UserData>>  findAllByUserId(long userId);
}
