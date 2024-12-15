package com.example.demo.designquestions.TicTacToeGame;

import java.util.ArrayList;
import java.util.List;

public class BoardGame {

    int size;
    PlayingPiece[][] board;

    BoardGame(int size){
        this.size=size;
        this.board=new PlayingPiece[size][size];
    }

    boolean addPiece(int x, int y, PlayingPiece playingPiece){
        if(board[x][y] !=null){
            return false;
        }
        board[x][y]=playingPiece;
        return true;
    }

    public List<Pair<Integer,Integer>> getFreeCells(){
        List<Pair<Integer,Integer>> freecells=new ArrayList<>();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]== null){
                    Pair<Integer,Integer> rowColumn=new Pair<>(i,j);
                    freecells.add(rowColumn);
                }
            }
        }

        return freecells;
    }


    public void printBoard() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].pieceType.name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();

        }
    }

}
