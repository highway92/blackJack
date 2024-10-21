package com.prime.cardDeck;

import lombok.Getter;

public enum CardValue {
    ACE(new Integer[]{1,11}),
    TWO(new Integer[]{2}),
    THREE(new Integer[]{3}),
    FOUR(new Integer[]{4}),
    FIVE(new Integer[]{5}),
    SIX(new Integer[]{6}),
    SEVEN(new Integer[]{7}),
    EIGHT(new Integer[]{8}),
    NINE(new Integer[]{9}),
    TEN(new Integer[]{10}),
    JACK(new Integer[]{10}),
    QUEEN(new Integer[]{10}),
    KING(new Integer[]{10});

    @Getter
    private final Integer[] value;

    private CardValue(Integer[] value) {
        this.value = value;
    }
}