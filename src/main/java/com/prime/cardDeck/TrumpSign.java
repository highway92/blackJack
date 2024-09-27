package com.prime.cardDeck;

public enum TrumpSign {
    SPADE("Spade"),
    HEART("Heart"),
    DIAMOND("Diamond"),
    CLUB("Club");

    private String sign;

    private TrumpSign(String sign) {
        this.sign = sign;
    }
}
