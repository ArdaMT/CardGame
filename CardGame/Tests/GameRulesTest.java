import main.java.GameRules;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GameRulesTest {
    private GameRules gr;
    private List<List<String>> testCardList;

    @BeforeEach
    void setUp() {
        System.out.println("running a test...");
        gr = new GameRules();
        System.out.println();
        testCardList = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        List<String> list4 = new ArrayList<>();
        List<String> list5 = new ArrayList<>();
        list1.add("Karo");
        list1.add("König");
        list2.add("Karo");
        list2.add("As");
        list3.add("Pik");
        list3.add("3");
        list4.add("Karo");
        list4.add("6");
        list5.add("Kreuz");
        list5.add("9");
        testCardList.add(list1);
        testCardList.add(list2);
        testCardList.add(list3);
        testCardList.add(list4);
        testCardList.add(list5);
    }

    @Test
    void findHighestSuitFrequency() {
        System.out.print("Test input: ");
        for (List l : testCardList) {
            System.out.print(l.get(0) + " " + l.get(1));
            if (testCardList.indexOf(l) < 4) {
                System.out.print(", ");
            }
        }
        Assertions.assertSame(3, gr.findHighestSuitFrequency(testCardList)[0]);
    }
}