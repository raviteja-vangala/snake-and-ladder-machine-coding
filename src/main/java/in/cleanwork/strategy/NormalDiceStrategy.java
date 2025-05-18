package in.cleanwork.strategy;

import java.util.Random;

public class NormalDiceStrategy implements DiceStrategy {

    private final Random random;

    public NormalDiceStrategy() {
        this.random = new Random();
    }

    @Override
    public int roll() {
        return random.nextInt(6) + 1;
    }
}
