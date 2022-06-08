package com.example.cardgame.game;

import lombok.Data;

@Data // @Getter @Setter @NoArgsConstructor  <--- ei lähe andmebaasi
public class Card {
    private Suit suit;
    private Rank rank;
    private int value;

    public Card() {
        this.suit = Suit.getRandomSuit(); // kindlasti 4
        this.rank = Rank.getRandomRank(); // kindlasti 13
        this.value = determineValue();
    }

    private int determineValue() {
        switch (rank) {
            case ACE:
            case KING:
            case QUEEN:
            case JACK:
            case TEN:
                return 10;
            case NINE:
                return 9;
            case EIGTH:
                return 8;
            case SEVEN:
                return 7;
            case SIX:
                return 6;
            case FIVE:
                return 5;
            case FOUR:
                return 4;
            case THREE:
                return 3;
            case TWO:
                return 2;
            default:
                return 0;
        }
    }
}
