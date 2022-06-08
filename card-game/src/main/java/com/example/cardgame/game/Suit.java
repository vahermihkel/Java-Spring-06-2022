package com.example.cardgame.game;

public enum Suit {
    HEART, CLUB, DIAMOND, SPADE;

    public static Suit getRandomSuit() {
        int index = (int) (Math.random() * values().length);
        return values()[index];
    }
}
