package org.example.model;

import java.util.Objects;

public class Board {
    Cell[][] cells;
    int n;

    public Board(int n) {
        this.n = n;
        this.cells = new Cell[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cells[i][j] = new Cell(i,j);
            }
        }
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void print(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(cells[i][j].getStatus() == CellStatus.EMPTY){
                    System.out.print("-");
                }else{
                    System.out.print(cells[i][j].getPlayer().getSymbol());
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public boolean makeMove(Move move){
        if(move.row >= n || move.col >= n || !isValid(move)){
            return false;
        }
        Cell cell = cells[move.row][move.col];
        cell.setStatus(CellStatus.OCCUPIED);
        cell.setPlayer(move.player);
        return true;
    }

    private boolean isValid(Move move){
        return cells[move.row][move.col].status == CellStatus.EMPTY;
    }

    public boolean won(Player player){
        // rows
        for(int i=0;i<n;i++){
            boolean flag = true;
            for(int j=0;j<n;j++){
                if(cells[i][j].getStatus() == CellStatus.EMPTY || !Objects.equals(player,cells[i][j].getPlayer())){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return true;
            }
        }

        //cols
        for(int i=0;i<n;i++){
            boolean flag = true;
            for(int j=0;j<n;j++){
                if(cells[j][i].getStatus() == CellStatus.EMPTY || !Objects.equals(player,cells[j][i].getPlayer())){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return true;
            }
        }

        //diagonals
        boolean flag = true;
        for(int i=0;i<n;i++){
            if(cells[i][i].getStatus() == CellStatus.EMPTY || !Objects.equals(player,cells[i][i].getPlayer())){
                flag = false;
                break;
            }
        }
        if(flag)return true;

        flag = true;
        for(int i=0;i<n;i++){
            if(cells[i][n-i-1].getStatus() == CellStatus.EMPTY || !Objects.equals(player,cells[i][n-i-1].getPlayer())){
                flag = false;
                break;
            }
        }
        return flag;
    }


}
