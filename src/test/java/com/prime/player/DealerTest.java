package com.prime.player;

import com.prime.cardDeck.Card;
import com.prime.cardDeck.CardValue;
import com.prime.cardDeck.TrumpSign;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealerTest {

    @Test
    @DisplayName("ACE와 SIX를 뽑으면 소프트 17이다.")
    void isSoftSeventeen() {
        Dealer sut = new Dealer();
        Card ace = new Card(TrumpSign.DIAMOND, CardValue.ACE);
        Card six = new Card(TrumpSign.DIAMOND, CardValue.SIX);
        sut.hit(ace);
        sut.hit(six);
        assertTrue(sut.isSoftSeventeen());
    }

    @Test
    @DisplayName("Jack, FIVE, ACE를 뽑으면 소프트 17이 아니다.")
    void isNotSoftSeventeen() {
        Dealer sut = new Dealer();
        Card ace = new Card(TrumpSign.DIAMOND, CardValue.ACE);
        Card five = new Card(TrumpSign.DIAMOND, CardValue.FIVE);
        Card jack = new Card(TrumpSign.DIAMOND, CardValue.JACK);
        sut.hit(ace);
        sut.hit(jack);
        sut.hit(five);
        assertFalse(sut.isSoftSeventeen());
    }

    @Test
    @DisplayName("Jack, Queen,4를 뽑으면 Busted다.")
    void isBusted() {
        Dealer sut = new Dealer();
        Card jack = new Card(TrumpSign.DIAMOND, CardValue.JACK);
        Card queen = new Card(TrumpSign.DIAMOND, CardValue.QUEEN);
        Card four = new Card(TrumpSign.DIAMOND, CardValue.FOUR);
        sut.hit(jack);
        sut.hit(queen);
        sut.hit(four);
        assertEquals(true, sut.isBusted());
    }

    @Test
    @DisplayName("6한장과 Ace 카드를 받으면 17점이다.")
    void sixAceScoreTest() {
        Dealer sut = new Dealer();
        Card six = new Card(TrumpSign.HEART, CardValue.SIX);
        sut.hit(six);
        Card ace = new Card(TrumpSign.DIAMOND, CardValue.ACE);
        sut.hit(ace);
        assertEquals(17, (int) sut.getScore());
    }

    @Test
    @DisplayName("5 4장과, Ace 카드를 받으면 21점이다.")
    void fiveAceScoreTest() {
        Dealer sut = new Dealer();
        for(TrumpSign sign: TrumpSign.values()) {
            Card five = new Card(sign, CardValue.FIVE);
            sut.hit(five);
        }
        Card ace = new Card(TrumpSign.DIAMOND, CardValue.ACE);
        sut.hit(ace);
        assertEquals(21, (int) sut.getScore());
    }
}