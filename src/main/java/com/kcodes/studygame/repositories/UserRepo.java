package com.kcodes.studygame.repositories;

import com.kcodes.studygame.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}