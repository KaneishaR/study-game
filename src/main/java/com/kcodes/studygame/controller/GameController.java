package com.kcodes.studygame.controller;

import com.kcodes.studygame.model.Game;
import com.kcodes.studygame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/game")
public class GameController {

    private GameService gameService;

    @Autowired
    public GameController(GameService service){ this.gameService = service; }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Game> getAllGames(){
        return gameService.getAllGames();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Game> getGameById(@PathVariable int id){
        return gameService.getGameById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Game saveGame(@RequestBody Game game){
        return gameService.saveGame(game);
    }
}
