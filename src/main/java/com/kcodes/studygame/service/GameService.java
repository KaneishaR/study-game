package com.kcodes.studygame.service;

import com.kcodes.studygame.model.Game;
import com.kcodes.studygame.repositories.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GameService {
    
    private GameRepo gameRepo;
    
    @Autowired
    public GameService(GameRepo repo){ this.gameRepo = repo;}

    public Game saveGame(Game game){
        return gameRepo.save(game);
    }

    public Game updateGame(Game game){

        return  gameRepo.save(game);
    }

    public boolean deleteGameById(int id){
        gameRepo.deleteById(id);
        return true;
    }

    public List<Game> getAllGames(){
        List<Game> games = new ArrayList<Game>();
        gameRepo.findAll().forEach(games::add);
        return games;
    }

    public Set<Game> getAllGamesByUserId(int id){
        Set<Game> games = gameRepo.findByUserId(id);
        return games;
    }

    public Optional<Game> getGameById(int id){
        return gameRepo.findById(id);
    }
}
