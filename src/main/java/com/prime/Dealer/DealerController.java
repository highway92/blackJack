package com.prime.Dealer;

import com.prime.cardDeck.Deck;
import com.prime.gameBoard.InputReader;

import java.util.Scanner;

public class DealerController {
    private final Dealer dealer;
    private final InputReader inputReader;
    private class defaultReader implements InputReader {
        private final Scanner scanner = new Scanner(System.in);

        public String readInput() {
            return scanner.next();
        }
    }

    public DealerController(Dealer dealer) {
        this.inputReader = new DealerController.defaultReader();
        this.dealer = dealer;
    }

    public void distributeCards(Deck deck) {
        try {
            Thread.sleep(1000);
            System.out.println("Distributing card to Dealer.. \n");
            dealer.hit(deck.pickCard());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private DealerCommand insertCommand() {
        while(true) {
            System.out.println("Which one do you want to Dealer should? (hit/stay)");
            String answer = inputReader.readInput();
            if (answer.equals("hit")) {
                return DealerCommand.HIT;
            }
            if (answer.equals("stay")) {
                return DealerCommand.STAY;
            }
            System.out.println("Please enter a valid option");
        }
    }

    public void doTurn(Deck deck) {
        try {
            Thread.sleep(1000);
            if(dealer.isBusted()) {
                System.out.println("Dealer is busted!");
                return;
            }
            if(dealer.getScore() < 17) {
                dealer.hit(deck.pickCard());
                doTurn(deck);
            }
            if(dealer.isSoftSeventeen()) {
                DealerCommand command = insertCommand();
                if(command == DealerCommand.HIT) {
                    dealer.hit(deck.pickCard());
                    doTurn(deck);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
