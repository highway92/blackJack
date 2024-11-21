package com.prime.player;

import com.prime.cardDeck.Card;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Player {
    private final String name;
    private final List<Card> hand = new ArrayList<>();
    @Getter(AccessLevel.NONE)
    private List<Integer> handScore = new ArrayList<>();
    private boolean done = false;

    public Player(String name) {
        this.name = name;
        this.handScore.add(0);
    }

    public String getStatus() {
        StringBuilder builder = new StringBuilder();
        builder.append("Player :").append(name).append("\n");
        builder.append("Hand :  ").append(getHand().toString()).append("\n");
        builder.append("HandScore : ").append(getScore().toString()).append("\n");
        return builder.toString();
    }

    public void hit(Card card) {
        if(done || isBusted()) {
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

    public void stay() {
        this.done = true;
    }

    public List<Card> getHand() {
        return List.copyOf(hand);
    }

    public boolean isBusted() {
        return handScore.isEmpty();
    }

    public Integer getScore() {
        return handScore.stream().max(Integer::compare).orElse(-1);
    }
}
