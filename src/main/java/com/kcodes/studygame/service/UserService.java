package com.kcodes.studygame.service;

import com.kcodes.studygame.exceptions.BadRequestException;
import com.kcodes.studygame.model.Game;
import com.kcodes.studygame.model.User;
import com.kcodes.studygame.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo repo){
        this.userRepo = repo;
    }


    public User saveUser(User user){
        return userRepo.save(user);
    }

    public User updateUser(User user){
        User persistedUser = userRepo.findByUsername(user.getUsername());
        persistedUser.setGameSet(user.getGameSet());
        return  userRepo.save(persistedUser);
    }

    public boolean deleteUserById(int id){
        userRepo.deleteById(id);
        return true;
    }

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<User>();
         userRepo.findAll().forEach(users::add);
         return users;
    }

    public Optional<User> getUserById(int id){
        return userRepo.findById(id);
    }

    public User getUserByUsername(String username){
        User user = userRepo.findByUsername(username);
        if (user == null){

            user = userRepo.save(new User(username));
        }
        return user;
    }
}
