package org.example.model;

public class Player {
    String name;
    char symbol;

    public Player(char symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
