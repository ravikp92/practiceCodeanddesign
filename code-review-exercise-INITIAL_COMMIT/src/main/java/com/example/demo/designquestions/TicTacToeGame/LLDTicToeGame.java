package com.example.demo.designquestions.TicTacToeGame;


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class LLDTicToeGame {

    Deque<Player> players;
    BoardGame boardGame;


    public void initializeGame(){
        players=new LinkedList<>();
        //initialize game
        PlayingPieceX playingPieceX=new PlayingPieceX();
        Player player1=new Player("Player1",playingPieceX);
        players.add(player1);

        PlayingPieceO playingPieceO=new PlayingPieceO();
        Player player2=new Player("Player2",playingPieceO);
        players.add(player2);
        System.out.println(players.size());
        //initialize board
        boardGame=new BoardGame(3);

    }

    String startGame(){
        boolean noWinner=false;

        while(noWinner){
            //take out the player whose turn is and also put the player in the list back
            Player playerTurn=players.removeFirst();

            //get the free space from the board
            boardGame.printBoard();
            List<Pair<Integer,Integer>> freeSpaces=boardGame.getFreeCells();
            if(freeSpaces.isEmpty()){
                noWinner=false;
                continue;
            }

            //read the user input
            System.out.println("Player:" + playerTurn.name + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);


            //place the piece
            boolean pieceAddedSuccess=boardGame.addPiece(inputRow,inputColumn,playerTurn.playingPiece);
            if(!pieceAddedSuccess) {
                //player can not insert the piece into this cell, player has to choose another cell
                System.out.println("Incorredt possition chosen, try again");
                players.addFirst(playerTurn);
                continue;
            }

            players.addLast(playerTurn);

            boolean winner= isThereWinner(inputRow,inputColumn,playerTurn.playingPiece.pieceType);

            if(winner)
                return playerTurn.name;
        }
        return "TIE";
    }

    private boolean isThereWinner(int inputRow, int inputColumn, PieceType pieceType) {
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<boardGame.size;i++) {

            if(boardGame.board[inputRow][i] == null || boardGame.board[inputRow][i].pieceType != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<boardGame.size;i++) {

            if(boardGame.board[i][inputColumn] == null || boardGame.board[i][inputColumn].pieceType != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<boardGame.size;i++,j++) {
            if (boardGame.board[i][j] == null || boardGame.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=boardGame.size-1; i<boardGame.size;i++,j--) {
            if (boardGame.board[i][j] == null || boardGame.board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }


}
