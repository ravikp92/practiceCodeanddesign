package com.example.demo.designquestions.TicTacToeGame;

public class Player {
    PlayingPiece playingPiece;
    String name;

    Player(String name,PlayingPiece playingPiece){
        this.name=name;
        this.playingPiece=playingPiece;
    }

    public PlayingPiece getPlayingPiece() {
        return playingPiece;
    }

    public void setPlayingPiece(PlayingPiece playingPiece) {
        this.playingPiece = playingPiece;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
