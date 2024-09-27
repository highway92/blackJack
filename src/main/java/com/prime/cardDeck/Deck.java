package com.prime.cardDeck;

import java.util.Random;

public class Deck {
    private final int numberOfCards = 52;

    private Card[] cards = new Card[numberOfCards];

    private void init() {
        int i = 0;
        for(TrumpSign trumpSign : TrumpSign.values()) {
            for(CardValue cardValue : CardValue.values()) {
                cards[i] = new Card(trumpSign, cardValue);
                i++;
            }
        }
        this.shuffle();
    }

    public void shuffle() {
        Random random = new Random();
        for(int i = numberOfCards - 1; i > 0; i--) {
            int randomIndex = random.nextInt(i + 1);
            Card target = cards[i];
            Card randomCard = cards[randomIndex];
            cards[i] = randomCard;
            cards[randomIndex] = target;
        }
    }

    public Card[] getCards() {
        return cards.clone();
    }

    public Deck() {
        this.init();
    }



}
