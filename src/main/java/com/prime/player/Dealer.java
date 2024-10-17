package com.prime.player;

import com.prime.cardDeck.Card;
import com.prime.cardDeck.CardValue;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Dealer {
    private final List<Card> hand = new ArrayList<Card>();

    public void hit(Card card) {
        hand.add(card);
    }

    public Integer getValueOfCards() {
        return hand.stream().map(Card::getCardValue).map(CardValue::getValue).reduce(0, Integer::sum);
    }
}
