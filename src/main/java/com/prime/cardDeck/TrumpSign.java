package com.prime.cardDeck;

import lombok.Getter;

public enum TrumpSign {
    SPADE("Spade"),
    HEART("Heart"),
    DIAMOND("Diamond"),
    CLUB("Club");

    @Getter
    private final String sign;

    private TrumpSign(String sign) {
        this.sign = sign;
    }
}
