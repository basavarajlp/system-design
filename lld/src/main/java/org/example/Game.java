package org.example;

import org.example.model.Board;
import org.example.model.Move;
import org.example.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Game {

    Board board;
    List<Player> players;
    int size;
    List<Move> moves;

    public Game(List<Player> players, int size) {
        this.board = new Board(size);
        this.players = players;
        this.size = size;
        this.moves = new ArrayList<>();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getPlayer(String name){
        return players.stream().filter(p-> p.getName().equals(name)).findFirst().orElse(null);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public static void main(String[] args) {
        System.out.println("Let's start the game. All the players be ready, register yourself!!");
        System.out.println("Enter the size of the board");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Board board = new Board(n);
        System.out.println(" Enter the "+(n-1)+" Players Detail");
        List<Player> players = new ArrayList<>();
        for(int i=0;i<(n-1);i++){
            System.out.println("Enter the name:");
            String name = sc.next();
            System.out.println("Enter the Symbol:");
            char sym = sc.next().charAt(0);
            Player player = new Player(sym,name);
            players.add(player);
        }
        Game game = new Game(players,n);
        /**
        int retries = 5;
        Player player = null;
        while(retries!=0){
            System.out.println("Enter the name of the player to make the first move");
            String name = sc.nextLine();
            player = game.getPlayer(name);
            if(Objects.isNull(player)){
                System.out.println(" No such player exists!!");
            }else{
                break;
            }
            retries--;
        }
        if(Objects.isNull(player)){
            System.out.println(" No player selected. Sorry we can't continue further!! Bye Bye!!");
        }
        **/
        game.play();
    }

    public void play(){
        Scanner sc = new Scanner(System.in);
        System.out.println(" Let the game begin's!! ");
        int count = 0;
        while(true){
            System.out.println(" New round of play ");
            for(Player player:players){
                board.print();
                Move move = null;
                do{
                    System.out.println(" Player "+player.getName()+" is making is move, please provide the row");
                    int row = sc.nextInt();
                    System.out.println(" enter the col ");
                    int col = sc.nextInt();
                    move = new Move(player,row,col);
                }while(!board.makeMove(move));
                System.out.println(" The move is valid !!");
                moves.add(move);
                if(board.won(player)) {
                    System.out.println(" Player " + player.getName() + " won the match!!");
                    board.print();
                    return;
                }
                count++;
                if(count == board.getN()*board.getN()){
                    System.out.println(" Unfortunately game ended in draw!! ");
                    board.print();
                    return;
                }
            }
        }
    }
}