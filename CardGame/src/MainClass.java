
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * In order to be able to run the program on the command prompt, please open the command prompt.
 * Copy the path to the folder in which this file is saved and enter the command "cd", a space and the path and press enter.
 * Now enter the command "javac" followed by a space and the name of this file.
 * After that, enter the command "java" followed by a blank and this file's name, here skip the ".java" extension in the file name.
 * <p>
 * <p>
 * This is a program for a simple game of cards between a player and the computer.
 * the program randomly allocates 5 cards to both the player and the computer.
 * It then applies the rules in the GameRules.java class and tells who won the round.
 * Here, the player has the option to play another round or to quit the game.
 *
 * @author Arda
 */
public class MainClass {

    private static PlayingCards pc;
    private static List<List<String>> playerCards;
    private static List<List<String>> computerCards;
    private static GameRules gr;
    private static boolean isNextGame = true;
    private static final Scanner sc = new Scanner(System.in);
    private static int[] playerFreqRankArr;
    private static int[] computerFreqRankArr;

    public static void main(String args[]) {
        System.out.println("");
        //The game is played as long as the player wishes to continue..
        while (isNextGame) {
            playerCards = new ArrayList<>();
            computerCards = new ArrayList<>();
            pc = new PlayingCards();
            System.out.print("Spieler: ");
            handOutCards(playerCards);
            System.out.println("");
            System.out.print("Computer: ");
            handOutCards(computerCards);
            System.out.println("");
            //calculate the player's highest suit Frequency and the value of ranks in the suit
            gr = new GameRules();
            playerFreqRankArr = gr.findHighestSuitFrequency(playerCards);
            System.out.println(playerFreqRankArr[0]+ " "+ playerFreqRankArr[1]);
            //calculate the computer's highest suit Frequency and the value of ranks in the suit
            gr.resetSuitFreqValue();
            computerFreqRankArr = gr.findHighestSuitFrequency(computerCards);
            System.out.println(computerFreqRankArr[0]+ " "+ computerFreqRankArr[1]);
            chooseWinner();
            decideNextRound();
        }
    }

    private static void decideNextRound() {
        while (true) {
            System.out.println("Wollen Sie noch eine Runde Spielen?   J/N");
            String answer = sc.nextLine();
            if (answer.equals("J")) {
                isNextGame = true;
                break;
            } else if (answer.equals("N")) {
                isNextGame = false;
                break;
            } else {
                System.out.println("Bitte nur mit J oder N beantworten.");
            }
        }
    }

    private static void handOutCards(List<List<String>> tempCards) {
        List<String> tempList;
        for (int i = 0; i < 5; i++) {
            String tempSuit = pc.getRandomSuit();
            String tempRank = pc.getRandomRank();
            System.out.print(tempSuit + " " + tempRank);
            if (i < 4) {
                System.out.print(", ");
            }
            tempList = new ArrayList<>();
            tempList.add(tempSuit);
            tempList.add(tempRank);
            tempCards.add(tempList);
        }
    }

    public static void chooseWinner() {
        if (playerFreqRankArr[0] > computerFreqRankArr[0]) {
            System.out.println("Sie haben diese Runde gewonnen!");
        } else if (playerFreqRankArr[0] < computerFreqRankArr[0]) {
            System.out.println("Computer hat diese Runde gewonnen!");
        } else {
            if (playerFreqRankArr[1] > computerFreqRankArr[1]) {
                System.out.println("Sie haben diese Runde gewonnen!");
            } else {
                System.out.println("Computer hat diese Runde gewonnen!");
            }
        }
    }
}
