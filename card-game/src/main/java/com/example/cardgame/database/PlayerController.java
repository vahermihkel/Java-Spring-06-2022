package com.example.cardgame.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    GameRepository gameRepository;

    @GetMapping("registrate-player/{playerName}")
    public boolean registratePlayer(@PathVariable String playerName) {
        Player player = new Player(playerName, new Date());
        playerRepository.save(player);
        return true;
    }

    @GetMapping("show-all-games/{playerName}")
    public List<Game> getGames(@PathVariable String playerName) {
        Player player = playerRepository.findById(playerName).get();
        return gameRepository.findAllByPlayer(player);
    }
}
