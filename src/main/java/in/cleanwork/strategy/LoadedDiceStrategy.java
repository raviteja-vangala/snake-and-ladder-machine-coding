package in.cleanwork.strategy;

import java.util.Random;

public class LoadedDiceStrategy implements DiceStrategy {

    private final Random random;

    public LoadedDiceStrategy() {
        this.random = new Random();
    }

    @Override
    public int roll() {
        return random.nextInt(3) + 4;
    }
}
