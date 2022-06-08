package com.example.cardgame.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, String> {
}
