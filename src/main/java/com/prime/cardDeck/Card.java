package com.prime.cardDeck;

import lombok.RequiredArgsConstructor;

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
}
