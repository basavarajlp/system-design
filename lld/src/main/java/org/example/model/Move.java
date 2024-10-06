package org.example.model;

public class Move {
    Player player;
    int row;
    int col;

    public Move(Player player, int row, int col) {
        this.player = player;
        this.row = row;
        this.col = col;
    }
}
