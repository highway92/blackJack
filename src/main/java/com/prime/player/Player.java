package com.prime.player;

import com.prime.cardDeck.Card;
import com.prime.cardDeck.CardValue;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Player {
    private final String name;
    private final List<Card> hand = new ArrayList<>();
    private boolean done = false;

    public Player(String name) {
        this.name = name;
    }

    public void hit(Card card) {
        hand.add(card);
    }

    public void stay() {
        this.done = true;
    }

    public boolean isBusted() {
        Integer handSum = this.hand.stream()
                .map(Card::getCardValue)
                .map(CardValue::getValue)
                .reduce(0,Integer::sum);
        return handSum > 21;
    }

    public List<Card> getHand() {
        return List.copyOf(hand);
    }
}
