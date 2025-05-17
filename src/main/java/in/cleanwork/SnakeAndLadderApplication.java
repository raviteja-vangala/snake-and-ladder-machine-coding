package in.cleanwork;

import in.cleanwork.model.Board;
import in.cleanwork.model.PlayerDetails;
import in.cleanwork.service.Game;

import java.util.*;

public class SnakeAndLadderApplication {

    public static void main(String[] args) {
        System.out.println("Welcome to Snake And Ladder Application");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Board Size: ");
        int boardSize = scanner.nextInt();
        System.out.println("Enter No of Dices: ");
        int noOfDices = scanner.nextInt();

        System.out.println("Number of snakes: ");
        // Read snakes
        int numSnakes = scanner.nextInt();

        System.out.println("Enter snake head and tail in multiple lines: ");
        Map<Integer, Integer> snakes = new HashMap<>();
        for (int i = 0; i < numSnakes; i++) {
            int head = scanner.nextInt();
            int tail = scanner.nextInt();
            snakes.put(head, tail);
        }

        System.out.println("Number of ladders: ");
        // Read ladders
        int numLadders = scanner.nextInt();

        System.out.println("Enter ladder start and end in multiple lines: ");
        Map<Integer, Integer> ladders = new HashMap<>();
        for (int i = 0; i < numLadders; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            ladders.put(start, end);
        }

        System.out.println("Enter number of players: ");
        // Read players
        int numPlayers = scanner.nextInt();

        System.out.println("Enter player names in multiple lines: ");
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

        Board board = Board.getInstance(boardSize, noOfDices, snakes, ladders);
        Game game = new Game(board, players);
        game.start();
    }
}
