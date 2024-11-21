package com.prime.Dealer;

import com.prime.cardDeck.Card;
import com.prime.cardDeck.CardValue;
import com.prime.cardDeck.Deck;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class Dealer {
    private final List<Card> hand = new ArrayList<Card>();
    private List<Integer> handScore = new ArrayList<Integer>(List.of(0));

    public String getPublicStatus() {
        StringBuilder builder = new StringBuilder();
        builder.append("Dealer: \n");
        builder.append("Hand : ").append(getPublicCard());
        return builder.toString();
    }

    public String getFullStatus() {
        StringBuilder builder = new StringBuilder();
        builder.append("Dealer: \n");
        builder.append("Hand : ").append(List.copyOf(hand)).append('\n');
        builder.append("Score : ").append(getScore());
        return builder.toString();
    }

    public void hit(Card card) {
        if(isBusted()) {
            return;
        }
        hand.add(card);
        List<Integer> tempHandValues = new ArrayList<>();
        for (Integer cardValue : card.getCardValues()) {
            for (Integer handValue : handScore) {
                tempHandValues.add(handValue + cardValue);
            }
        }
        handScore = tempHandValues.stream().filter(value -> value <= 21).collect(Collectors.toCollection(ArrayList::new));
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
