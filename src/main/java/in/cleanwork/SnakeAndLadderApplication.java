package in.cleanwork;

import in.cleanwork.command.Command;
import in.cleanwork.command.MoveCommand;
import in.cleanwork.dto.Board;
import in.cleanwork.factory.ObstacleFactory;
import in.cleanwork.observer.Player;
import in.cleanwork.service.Game;
import in.cleanwork.strategy.DiceStrategy;
import in.cleanwork.strategy.NormalDiceStrategy;

import java.util.*;

public class SnakeAndLadderApplication {

    public static void main(String[] args) {
        System.out.println("Welcome to Snake And Ladder Application");

//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Enter Board Size: ");
//        int boardSize = scanner.nextInt();
//        System.out.println("Enter No of Dices: ");
//        int noOfDices = scanner.nextInt();
//
//        System.out.println("Number of snakes: ");
//        // Read snakes
//        int numSnakes = scanner.nextInt();
//
//        System.out.println("Enter snake head and tail in multiple lines: ");
//        Map<Integer, Integer> snakes = new HashMap<>();
//        for (int i = 0; i < numSnakes; i++) {
//            int head = scanner.nextInt();
//            int tail = scanner.nextInt();
//            snakes.put(head, tail);
//        }
//
//        System.out.println("Number of ladders: ");
//        // Read ladders
//        int numLadders = scanner.nextInt();
//
//        System.out.println("Enter ladder start and end in multiple lines: ");
//        Map<Integer, Integer> ladders = new HashMap<>();
//        for (int i = 0; i < numLadders; i++) {
//            int start = scanner.nextInt();
//            int end = scanner.nextInt();
//            ladders.put(start, end);
//        }
//
//        System.out.println("Enter number of players: ");
//        // Read players
//        int numPlayers = scanner.nextInt();
//
//        System.out.println("Enter player names in multiple lines: ");
//        List<Player> players = new ArrayList<>();
//        scanner.nextLine(); // Consume the remaining newline
//        for (int i = 0; i < numPlayers; i++) {
//            String name = scanner.nextLine().trim();
//            players.add(new Player(name));
//        }
//
//        // Output (for verification)
//        System.out.println("Snakes: " + snakes);
//        System.out.println("Ladders: " + ladders);
//        System.out.println("Players:");
//        for (Player player : players) {
//            System.out.println(player);
//        }
//
//        scanner.close();

        Board board = Board.getInstance(100);
        ObstacleFactory.createSnakes(board, Arrays.asList(new int[][]{{16, 6}, {48, 26}, {49, 11}, {56, 53}, {62, 19}, {64, 60}, {87, 24}, {93, 73}, {95, 75}, {98, 78}}));
        ObstacleFactory.createLadders(board, Arrays.asList(new int[][]{{1, 38}, {4, 14}, {9, 31}, {21, 42}, {28, 84}, {36, 44}, {51, 67}, {71, 91}, {80, 100}}));

        Game game = new Game();
        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");

        game.addPlayer(player1);
        game.addPlayer(player2);

        DiceStrategy dice = new NormalDiceStrategy();

        while (true) {
            Player currentPlayer = game.getCurrentPlayer();
            int diceRoll = dice.roll();
            Command moveCommand = new MoveCommand(currentPlayer, diceRoll, board);
            moveCommand.execute();

            game.notifyPlayers(currentPlayer.getName() + " rolled a " + diceRoll + " and moved to " + currentPlayer.getPosition());

            if (currentPlayer.getPosition() == board.getSize()) {
                game.notifyPlayers(currentPlayer.getName() + " wins!");
                break;
            }

            game.nextTurn();
        }
    }
}
