package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * This class contains the rules to be applied to a set of 5 cards  passed.
 *
 * @author Arda
 */
public class GameRules {


    //Array contains tuples. Each tuple has a suit and the sum of the values of the cards in that suit. the order is: hearts, diamonds, spades, clubs, or in german: Herz, Karo, Kreuz, Pik
    int[][] suitFreqValue = {{0, 0}, {0, 0}, {0, 0}, {0, 0}};


    public int[] findHighestSuitFrequency(List<List<String>> cardList) {
        for (int i = 0; i < cardList.size(); i++) {
            String suit = cardList.get(i).get(0);
            String rank = cardList.get(i).get(1);
            if (suit.equals("Herz")) {
                suitFreqValue[0][0]++;
                addRankValueToSuit(0, rank);
            } else if (suit.equals("Karo")) {
                suitFreqValue[1][0]++;
                addRankValueToSuit(1, rank);
            } else if (suit.equals("Kreuz")) {
                suitFreqValue[2][0]++;
                addRankValueToSuit(2, rank);
            } else {
                suitFreqValue[3][0]++;
                addRankValueToSuit(3, rank);
            }
        }
        sortSuitFrequencies();
        System.out.println();
        System.out.println(suitFreqValue[0][0]+ " "+ suitFreqValue[0][1]);
        System.out.println(suitFreqValue[1][0]+ " "+ suitFreqValue[1][1]);
        System.out.println(suitFreqValue[2][0]+ " "+ suitFreqValue[2][1]);
        System.out.println(suitFreqValue[3][0]+ " "+ suitFreqValue[3][1]);
        //the suit with the highest frequency and the value of cards in that suit  will be saved to the respective variables.
        //in case of a tie for the highest frequency, the  suit with the higher value will be preferred.
        if (suitFreqValue[0][0] == suitFreqValue[1][0]) {
            if (suitFreqValue[0][1] >= suitFreqValue[1][1]) {
                return suitFreqValue[0];
            } else {
                return suitFreqValue[1];
            }
        }
        return suitFreqValue[0];
    }

    private int[][] addRankValueToSuit(int i, String rank) {
        switch (rank) {
            case "As":
                suitFreqValue[i][1] += 11;
                break;
            case "König":
            case "Bube":
            case "Dame":
                suitFreqValue[i][1] += 10;
                break;
            default:
                suitFreqValue[i][1] += Integer.parseInt(rank);
                break;
        }
        return suitFreqValue;
    }

    //sort the suit values saved in the first column of the array suitFreqValue in a descending order.
    private void sortSuitFrequencies() {
        Arrays.sort(suitFreqValue, new Comparator<int[]>() {
            @Override
            public int compare(final int[] entry1,
                               final int[] entry2) {
                if (entry1[0] < entry2[0])
                    return 1;
                else
                    return -1;
            }
        });
    }

    public void resetSuitFreqValue(){
       int[][] newsuitFreqValue= {{0,0},{0,0},{0,0},{0,0}};
       suitFreqValue=newsuitFreqValue;
    }
}