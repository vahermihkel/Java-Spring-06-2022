package com.example.cardgame.game;

import com.example.cardgame.database.Game;
import com.example.cardgame.database.GameRepository;
import com.example.cardgame.database.Player;
import com.example.cardgame.database.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class CardController {
    private Card card;
    long time;
    int correctAnswers = 0;
    int totalAnswers = 0;
    int lives = 3;
    Player player;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    GameRepository gameRepository;

    @GetMapping("start-game/{playerName}")
    public Card startRound(@PathVariable String playerName) {
        player = playerRepository.findById(playerName).get();
        correctAnswers = 0;
        totalAnswers = 0;
        card = new Card();
        time = System.currentTimeMillis();
        return card;
    }

    @GetMapping("player-action/{response}")
    public String playerAction(@PathVariable String response) {
        totalAnswers++;
        int oldValue = card.getValue();
        card = new Card();
        int newValue = card.getValue();
        if (System.currentTimeMillis()-10000 > time)  {
            lives--;
            return "TIME_OUT";
        }
        if (response.equals("higher") && newValue > oldValue ||
                response.equals("equal") && newValue == oldValue ||
                    response.equals("lower") && newValue < oldValue
        ) {
            correctAnswers++;
            return "USER_WINS";
        }
        lives--;
        return "USER_WRONG";
    }

    @GetMapping("new-round")
    public Card newRound() {
        time = System.currentTimeMillis();
        if (lives <= 0) {
            Game game = new Game(null, new Date(), correctAnswers, totalAnswers, player);
            gameRepository.save(game);
            lives = 3;
            return null;
        }
        return card;
    }


}
