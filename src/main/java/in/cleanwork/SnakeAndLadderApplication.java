package in.cleanwork;

import in.cleanwork.model.Board;
import in.cleanwork.model.PlayerDetails;
import in.cleanwork.service.Game;

import java.util.*;

public class SnakeAndLadderApplication {

    public static void main(String[] args) {
        System.out.println("Welcome to Snake And Ladder Application");

        Scanner scanner = new Scanner(System.in);

        int boardSize = scanner.nextInt();
        int noOfDices = scanner.nextInt();

        // Read snakes
        int numSnakes = scanner.nextInt();
        Map<Integer, Integer> snakes = new HashMap<>();
        for (int i = 0; i < numSnakes; i++) {
            int head = scanner.nextInt();
            int tail = scanner.nextInt();
            snakes.put(head, tail);
        }

        // Read ladders
        int numLadders = scanner.nextInt();
        Map<Integer, Integer> ladders = new HashMap<>();
        for (int i = 0; i < numLadders; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            ladders.put(start, end);
        }

        // Read players
        int numPlayers = scanner.nextInt();
        List<PlayerDetails> players = new ArrayList<>();
        scanner.nextLine(); // Consume the remaining newline
        for (int i = 0; i < numPlayers; i++) {
            String name = scanner.nextLine().trim();
            players.add(new PlayerDetails(name));
        }

        // Output (for verification)
        System.out.println("Snakes: " + snakes);
        System.out.println("Ladders: " + ladders);
        System.out.println("Players:");
        for (PlayerDetails player : players) {
            System.out.println(player);
        }

        scanner.close();

        Board board = new Board(boardSize, noOfDices, snakes, ladders);
        Game game = new Game(board, players);
        game.start();
    }
}
