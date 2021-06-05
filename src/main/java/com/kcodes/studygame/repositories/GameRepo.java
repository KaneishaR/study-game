package com.kcodes.studygame.repositories;

import com.kcodes.studygame.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface GameRepo extends CrudRepository<Game, Integer> {
    Set<Game> findByUserId(int userId);
}
