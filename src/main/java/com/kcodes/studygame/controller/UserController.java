package com.kcodes.studygame.controller;

import com.kcodes.studygame.model.Game;
import com.kcodes.studygame.model.User;
import com.kcodes.studygame.service.GameService;
import com.kcodes.studygame.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private UserService userService;
    private GameService gameService;

    @Autowired
    public UserController(UserService service){ this.userService = service;}

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<User> getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @GetMapping(value = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserByUsername(@PathVariable String username){
        return userService.getUserByUsername(username);
    }


    @GetMapping(value = "/{id}/games", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Game> getUserGames(@PathVariable int id){
        return gameService.getAllGamesByUserId(id);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping(value = "/{id}")
    public boolean deleteUserById(@PathVariable int id){
        return deleteUserById(id);
    }
}
