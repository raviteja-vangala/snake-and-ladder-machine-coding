package in.cleanwork.service;

import in.cleanwork.model.Board;
import in.cleanwork.model.PlayerDetails;

import java.util.List;

public class Game {

    private final Board board;
    private final List<PlayerDetails> playerDetailsList;

    public Game(Board board, List<PlayerDetails> playerDetailsList) {
        this.board = board;
        this.playerDetailsList = playerDetailsList;
    }

    public void start() {
        while (playerDetailsList.size() > 1) {
            for (PlayerDetails playerDetails : playerDetailsList) {

                int diceValue = board.getDiceValue();
                int newPosition = board.getNewPosition(playerDetails.getPosition(), diceValue);

                printDetails(playerDetails, diceValue, newPosition);
                playerDetails.setPosition(newPosition);

                if (checkForWin(playerDetails)) {
                    playerDetailsList.remove(playerDetails);
                    printWinner(playerDetails);
                    break;
                }
            }
        }

    }

    private boolean checkForWin(PlayerDetails playerDetails) {
        return board.reachedEnd(playerDetails.getPosition());
    }

    private void printDetails(PlayerDetails playerDetails, int diceValue, int newPosition) {
        String message = String.format("%s rolled a %d and moved from %d to %d", playerDetails.getName(), diceValue, playerDetails.getPosition(), newPosition);
        System.out.println(message);
    }

    private void printWinner(PlayerDetails playerDetails) {
        String message = String.format("%s wins the game", playerDetails.getName());
        System.out.println(message);
    }
}
