package com.example.cardgame.game;

public enum Rank {
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGTH, NINE, TEN, JACK, QUEEN, KING, ACE;

    public static Rank getRandomRank() {
        //List     -> .get(index)    juurde lisada, ära võtta, muuta
        //Integer[]     ->   [index]    saan ainult võtta/vaadata
        int index = (int) (Math.random() * values().length);
        return values()[index];
    }
}
