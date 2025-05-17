package in.cleanwork.model;

import java.util.Random;

public class Dice {

    private Dice() {
    }

    private static final Random random = new Random();

    public static int roll(int numberOfDices) {

        int diceValue = 0;
        for (int dice = 1; dice <= numberOfDices; dice++) {
            diceValue += (random.nextInt(6) + 1);
        }

        return diceValue;
    }
}
