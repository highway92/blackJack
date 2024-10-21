package com.prime.player;

import com.prime.cardDeck.Card;
import com.prime.cardDeck.CardValue;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Dealer {
    private Card hiddenCard;
    private final List<Card> hand = new ArrayList<Card>();

    public void getHiddenCard(Card card) {
        this.hiddenCard = card;
    }

    public void hit(Card card) {
        hand.add(card);
    }

    private Integer getPublicCardValue() {
        return hand.stream().map(Card::getCardValue).map(CardValue::getValue).reduce(0, Integer::sum);
    }

    public Integer getScore() {
        Integer hiddenCardValue = hiddenCard.getCardValue().getValue();
        Integer publicCardValue = getPublicCardValue();
        return publicCardValue + hiddenCardValue;
    }
}
