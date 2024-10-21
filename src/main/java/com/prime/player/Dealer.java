package com.prime.player;

import com.prime.cardDeck.Card;
import com.prime.cardDeck.CardValue;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class Dealer {
    private final List<Card> hand = new ArrayList<Card>();
    private List<Integer> handScore = new ArrayList<Integer>(List.of(0));

    public void hit(Card card) {
        hand.add(card);
        List<Integer> tempHandValues = new ArrayList<>();
        for (Integer cardValue : card.getCardValues()) {
            for (Integer handValue : handScore) {
                tempHandValues.add(handValue + cardValue);
            }
        }
        handScore = tempHandValues.stream().filter(value -> value <= 21).collect(Collectors.toCollection(ArrayList::new));
        if(isBusted()) {
            System.out.println("Dealer Busted!");
        }
    }

    public boolean isSoftSeventeen() {
        boolean isACE = false;
        boolean isSix = false;
        for (Card card : hand.subList(0,2)) {
            if(card.getCardValue() == CardValue.ACE) {
                isACE = true;
            }
            if(card.getCardValue() == CardValue.SIX) {
                isSix = true;
            }
        }
        return isACE && isSix;
    }

    private List<Card> getPublicCard() {
        return hand.subList(1, hand.size());
    }

    public boolean isBusted() {
        return handScore.isEmpty();
    }

    public Integer getScore() {
        return handScore.stream().max(Integer::compare).orElse(-1);
    }
}
