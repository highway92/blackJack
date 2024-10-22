package com.prime.player;

import com.prime.cardDeck.Card;
import com.prime.cardDeck.CardValue;
import com.prime.cardDeck.TrumpSign;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    @DisplayName("Jack, Queen, Ace 카드를 받으면 21점이다.")
    void JackQueenAceScoreTest() {
        Player sut = new Player("p1");
        Card jack = new Card(TrumpSign.DIAMOND, CardValue.JACK);
        Card queen = new Card(TrumpSign.DIAMOND, CardValue.QUEEN);
        Card ace = new Card(TrumpSign.DIAMOND, CardValue.ACE);
        sut.hit(jack);
        sut.hit(queen);
        sut.hit(ace);
        assertEquals(21, (int) sut.getScore());
    }

    @Test
    @DisplayName("King, Ace 카드를 받으면 21점이다.")
    void kingAceScoreTest() {
        Player sut = new Player("p1");
        Card king = new Card(TrumpSign.DIAMOND, CardValue.KING);
        Card ace = new Card(TrumpSign.DIAMOND, CardValue.ACE);
        sut.hit(king);
        sut.hit(ace);
        assertEquals(21, (int) sut.getScore());
    }

    @Test
    @DisplayName("5 4장과, Ace 카드를 받으면 21점이다.")
    void fiveAceScoreTest() {
        Player sut = new Player("p1");
        for(TrumpSign sign: TrumpSign.values()) {
            Card five = new Card(sign, CardValue.FIVE);
            sut.hit(five);
        }
        Card ace = new Card(TrumpSign.DIAMOND, CardValue.ACE);
        sut.hit(ace);
        assertEquals(21, (int) sut.getScore());
    }

    @Test
    @DisplayName("6한장과 Ace 카드를 받으면 17점이다.")
    void sixAceScoreTest() {
        Player sut = new Player("p1");
        Card six = new Card(TrumpSign.HEART, CardValue.SIX);
        sut.hit(six);
        Card ace = new Card(TrumpSign.DIAMOND, CardValue.ACE);
        sut.hit(ace);
        assertEquals(17, (int) sut.getScore());
    }

    @Test
    @DisplayName("Jack, Queen, 4를 받으면 Busted다")
    void JackQueenFourBustedScoreTest() {
        Player sut = new Player("p1");
        Card jack = new Card(TrumpSign.DIAMOND, CardValue.JACK);
        Card queen = new Card(TrumpSign.DIAMOND, CardValue.QUEEN);
        Card ace = new Card(TrumpSign.DIAMOND, CardValue.FOUR);
        sut.hit(jack);
        sut.hit(queen);
        sut.hit(ace);
        assertEquals(true, sut.isBusted());
    }
}