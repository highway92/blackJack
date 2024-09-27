package com.prime.cardDeck;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Card {
    private final TrumpSign trumpSign;
    private final CardValue cardValue;


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(trumpSign.name());
        builder.append(cardValue.name());
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return trumpSign == card.trumpSign  && cardValue == card.cardValue;
    }

    @Override
    public int hashCode() {
        return trumpSign.hashCode() + cardValue.hashCode();
    }
}
