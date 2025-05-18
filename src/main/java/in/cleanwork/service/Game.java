package in.cleanwork.service;

import in.cleanwork.observer.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private int currentPlayerIndex;
    private final List<Player> playerList;

    public Game() {
        this.playerList = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        playerList.add(player);
    }

    public Player getCurrentPlayer() {
        return playerList.get(currentPlayerIndex);
    }

    public void nextTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % playerList.size();
    }

    public void notifyPlayers(String message) {
        for (Player player : playerList) {
            player.update(message);
        }
    }
}
