package com.company;

import java.util.Scanner;

public class Ex5 {

    public static final char[] GAME_BOARD = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public static final char NO_WINNER = '-';

    public static final char PLAYER_1 = 'x';
    public static final char PLAYER_2 = 'o';

    public static void main(String[] args) {
        playAction();
    }

    public static void playAction() {
        printBoard(GAME_BOARD);
        char winner;
        boolean thereIsWinner = false;
        int turnCounter = 0;
        while (turnCounter != 9 && !thereIsWinner) {
            getPositionFromUser(GAME_BOARD, turnCounter);
            winner = getPlayerTurn(turnCounter);
            winner = checkWinner(GAME_BOARD, winner);
            if (winner != NO_WINNER) {
                System.out.println("There is winner: " + winner);
                thereIsWinner = true;
            }
            turnCounter++;
        }
        if (!thereIsWinner) {
            System.out.println("There is no winner");
        }
    }

    public static void printBoard(char[] board) {
        System.out.println(" ");
        for (int i = 0; i < board.length; i += 3) {
            System.out.print(board[i] + " " + board[i + 1] + " " + board[i + 2]);
            System.out.println(" ");
        }
    }

    public static boolean isAvailable(char[] board, int userNumberToCheck) {
        return board[userNumberToCheck - 1] != PLAYER_1 && board[userNumberToCheck - 1] != PLAYER_2;
    }

    public static char getPlayerTurn(int turnCounter) {
        char playerID;
        if (turnCounter % 2 == 0) {
            playerID = PLAYER_1;
        } else {
            playerID = PLAYER_2;
        }
        return playerID;
    }

    public static void getPositionFromUser(char[] gameBoard, int player) {
        boolean check;
        char playerID = getPlayerTurn(player);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose a number between 1-9 " + playerID);
        int userInput = scanner.nextInt();
        if (userInput < 1 || userInput > GAME_BOARD.length) {
            do {
                System.out.println("Try again. ( Choose only between 1 - 9)");
                userInput = scanner.nextInt();
            } while ((userInput <= 0 || userInput >= GAME_BOARD.length + 1));
        }
        check = isAvailable(gameBoard, userInput);
        if (!check) {
            do {
                System.out.println("There is already an X/O on that pattern, try again.");
                userInput = scanner.nextInt();
                check = isAvailable(gameBoard, userInput);
            } while (!check);
        }
        placeSymbolOnBoard(gameBoard, userInput, playerID);
    }

    public static char checkWinner(char[] boardGame, char playerID) {
        char winnerChar = NO_WINNER;
        char colum = checkWinnerByColum(boardGame, playerID);
        char row = checkWinnerByRow(boardGame, playerID);
        char slant = checkWinnerBySlant(boardGame, playerID);
        if (colum != winnerChar || row != winnerChar || slant != winnerChar) {
            winnerChar = playerID;
        }
        return winnerChar;
    }

    public static char checkWinnerByRow(char[] boardGame, char playerID) {
        char winner = NO_WINNER;
        for (int i = 0; i <= 2; i++) { //Check's winner on row
            if (boardGame[i] == playerID) {
                if (boardGame[i + 3] == boardGame[i + 6] && boardGame[i + 3] == playerID) {
                    winner = playerID;
                    break;
                }
            }
        }
        return winner;
    }

    public static char checkWinnerByColum(char[] boardGame, char playerID) {
        char winner = NO_WINNER;
        for (int i = 0; i < boardGame.length; i += 3) { //Check's winner on row
            if (boardGame[i] == playerID) {
                if (boardGame[i + 1] == boardGame[i + 2] && boardGame[i + 2] == playerID) {
                    winner = playerID;
                    break;
                }
            }
        }
        return winner;
    }

    public static char checkWinnerBySlant(char[] boardGame, char playerID) {
        char winner = NO_WINNER;
        if (boardGame[4] == playerID) {
            for (int i = 0; i <= 2; i += 2) { //Check's winner on row
                if (boardGame[i] == boardGame[boardGame.length - 1 - i] && boardGame[i] == playerID) {
                    winner = playerID;
                    break;
                }
            }
        }
        return winner;
    }

    public static void placeSymbolOnBoard(char[] gameBoard, int placeOnBoard, char playerX) {
        for (int i = 0; i < gameBoard.length + 1; i++) {
            if (i == placeOnBoard) {
                gameBoard[i - 1] = playerX;
            }
        }
        printBoard(gameBoard);
    }
}



