package com.example.demo.designquestions.TicTacToeGame;

public class RunGame {
    public static void main(String[] args) {
        LLDTicToeGame ticToeGame=new LLDTicToeGame();
        ticToeGame.initializeGame();
        System.out.println("Game winner is.."+ticToeGame.startGame());
    }
}
