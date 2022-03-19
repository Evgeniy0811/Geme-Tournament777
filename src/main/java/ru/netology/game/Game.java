package ru.netology.game;

import ru.netology.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {

    private final List<Player> players = new ArrayList<>();

    public Player[] findAll() {
        return players.toArray(new Player[0]);
    }

    public void register(Player player) {
        if (findByName(player.getName()) != null) {
        }
        else {
            players.add(player);
        }
    }

    public int round(Player playerName1, Player playerName2) {
        Player player1 = findByName(playerName1.getName());
        Player player2 = findByName(playerName2.getName());
        if (player1 == null || player2 == null) {
            throw new NotFoundException("One of the players is not registered");
        } else {
            if (player1.getStrength() == player2.getStrength()) return 0;
            return player1.getStrength() > player2.getStrength() ? 1 : 2;
        }
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (Objects.equals(player.getName(), name)) {
                return player;
            }
        }
        return null;
    }
}