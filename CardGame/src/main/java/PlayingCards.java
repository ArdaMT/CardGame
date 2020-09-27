package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class creates a deck of 52 playing cards, that consists of the common four suits of hearts, diamonds, spades and clubs
 * and the rank values of 2,3,4,5,6,7,8,9,10, ace, king, queen and jack for each suit.
 * <p>
 * the Order of the cards in the deck or within each suit doesn't play a role.
 *
 * @author Arda
 */
public class PlayingCards {
    private Random rnd;
    private List<String> suitList;
    private List<String> rankList;
    private List<List<String>> deckList;
    private int currentSuit;

    public PlayingCards() {
        rnd = new Random();
        suitList = new ArrayList<>();
        rankList = new ArrayList<>();
        deckList = new ArrayList<>();
        populateDeckList();
        populateSuitLists();
    }

    public String getRandomRank() {
        int rankIndex = rnd.nextInt(deckList.get(currentSuit).size());
        String tempStr = deckList.get(currentSuit).get(rankIndex);
        deckList.get(currentSuit).remove(rankIndex);
        return tempStr;
    }

    public String getRandomSuit() {
        currentSuit = rnd.nextInt(suitList.size());
        String tempStr = suitList.get(currentSuit);
        return tempStr;
    }

    private void populateSuitLists() {
        suitList.add("Kreuz");
        suitList.add("Pik");
        suitList.add("Herz");
        suitList.add("Karo");
    }

    private void populateDeckList() {
        rankList.add("As");
        rankList.add("König");
        rankList.add("Dame");
        rankList.add("Bube");
        rankList.add("2");
        rankList.add("3");
        rankList.add("4");
        rankList.add("5");
        rankList.add("6");
        rankList.add("7");
        rankList.add("8");
        rankList.add("9");
        rankList.add("10");

        //Here we add the list of Rank values 4 times, one for each suit.
        deckList.add(rankList);
        deckList.add(rankList);
        deckList.add(rankList);
        deckList.add(rankList);
    }
}

