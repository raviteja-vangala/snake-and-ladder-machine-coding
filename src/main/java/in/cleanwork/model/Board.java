package in.cleanwork.model;

import java.util.Map;

public class Board {

    private static Board instance;

    private final int size;
    private final int numberOfDices;
    private final Map<Integer, Integer> snakes; // key -> head, value -> tail
    private final Map<Integer, Integer> ladders; // key -> start, value -> end

    private Board(int size, int numberOfDices, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
        this.size = size;
        this.numberOfDices = numberOfDices;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public static Board getInstance(int size, int numberOfDices, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
        Board result = instance;
        if (result != null) return result;

        synchronized (Board.class) {
            if (instance == null) {
                instance = new Board(size, numberOfDices, snakes, ladders);
            }

            return instance;
        }
    }

    public int getDiceValue() {
        return Dice.roll(numberOfDices);
    }

    public int getNewPosition(int startPosition, int diceValue) {

        int newPosition = startPosition + diceValue;

        // check if it is a valid final Position
        if (!isValidPosition(newPosition)) return startPosition;

        // check if there is a start of a ladder
        if (isStartOfLadder(newPosition)) {
            newPosition = ladders.get(newPosition);
            return getNewPosition(newPosition, 0);
        }

        // check if there is head of a snake
        if (isHeadOfSnake(newPosition)) {
            newPosition = snakes.get(newPosition);
            return getNewPosition(newPosition, 0);
        }

        return newPosition;
    }

    public boolean reachedEnd(int position) {
        return position == size;
    }

    private boolean isValidPosition(int position) {
        return position <= size;
    }

    private boolean isStartOfLadder(int position) {
        return ladders.containsKey(position);
    }

    private boolean isHeadOfSnake(int position) {
        return snakes.containsKey(position);
    }
}
