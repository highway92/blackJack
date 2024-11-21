package com.prime.cardDeck;

import java.util.Random;

public class Deck {
    private final int numberOfCards = 52;
    private int cardSequence = 0;

    private Card[] cards = new Card[numberOfCards];

    public void shuffle() {
        this.cardSequence = 0;
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

    public Card pickCard() {
        if(cardSequence >= numberOfCards) { throw new IndexOutOfBoundsException("카드수는 52장 입니다."); }
        Card result = cards[cardSequence];
        cardSequence++;
        return result;
    }

    public Deck() {
        int i = 0;
        for(TrumpSign trumpSign : TrumpSign.values()) {
            for(CardValue cardValue : CardValue.values()) {
                cards[i] = new Card(trumpSign, cardValue);
                i++;
            }
        }
        this.shuffle();
    }

}
