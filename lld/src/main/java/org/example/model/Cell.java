package org.example.model;

public class Cell {
    int row;
    int col;
    Player player;
    CellStatus status;

    Cell(int row,int col){
        this.row =row;
        this.col = col;
        this.status = CellStatus.EMPTY;
    }

    public CellStatus getStatus() {
        return status;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setStatus(CellStatus status) {
        this.status = status;
    }
}
