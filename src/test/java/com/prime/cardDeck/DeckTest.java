package com.prime.cardDeck;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    @Test
    @DisplayName("덱에 있는 모든 카드는 null이 아니다.")
    void deckNotNullTest() {
        Deck deck = new Deck();
        for(Card card : deck.getCards()) {
            assertNotNull(card, "덱에 Null 카드가 있습니다.");
        }
    }

    @Test
    @DisplayName("덱 카드의 수는 52장이다.")
    void deckSizeTest() {
        Deck deck = new Deck();
        assertEquals(52, deck.getCards().length, "덱의 카드수가 52장이 아닙니다.");
    }

    @Test
    @DisplayName("초기화 된 덱은 셔플된 상태여야 한다.")
    void deckShuffledTest() {
        Deck deck = new Deck();
        Deck compareDeck = new Deck();

        boolean isShuffled = false;

        for(int i = 0; i < deck.getCards().length; i++) {
            Card card = deck.getCards()[i];
            Card compareCard = compareDeck.getCards()[i];
            if(!card.equals(compareCard)) {
                isShuffled = true;
                break;
            }
        }

        assertTrue(isShuffled);
    }


}