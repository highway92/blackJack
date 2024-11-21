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

    public void printStatus() {
        System.out.println("Player :" + name);
        System.out.println("Hand :  " + getHand().toString());
        System.out.println("HandScore : " + getScore().toString());
    }

    public void hit(Card card) {
        if(done) {
            System.out.println("Error occurred Player " + name + "'s turn is over");
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
        if(isBusted()) {
            done = true;
            System.out.println("Busted! " + name + "'s turn end. ^0^");
        }
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
