package in.cleanwork.dto;

import java.util.HashMap;
import java.util.Map;

public class Board {

    public static Board getInstance(int size) {
        Board result = instance;
        if (instance != null) return result;

        synchronized (Board.class) {
            if (instance == null) {
                instance = new Board(size);
            }

            return instance;
        }
    }

    private static Board instance;

    private Board(int size) {
        this.size = size;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
    }

    public int getSize() {
        return size;
    }

    public void addSnake(int head, int tail) {
        snakes.put(head, tail);
    }

    public void addLadder(int start, int end) {
        ladders.put(start, end);
    }

    private final int size;

    public Map<Integer, Integer> getSnakes() {
        return snakes;
    }

    public Map<Integer, Integer> getLadders() {
        return ladders;
    }

    private final Map<Integer, Integer> snakes;
    private final Map<Integer, Integer> ladders;
}
