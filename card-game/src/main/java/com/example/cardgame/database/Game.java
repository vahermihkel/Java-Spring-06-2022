package com.example.cardgame.database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Game {
    @Id
    @GeneratedValue
    private Long id;
    private Date date;
    private int correctAnswers;
    private int totalAnswers;
    @ManyToOne
    private Player player;
}
