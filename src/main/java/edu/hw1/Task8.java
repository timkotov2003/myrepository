package edu.hw1;

public class Task8 {

    private static final int SIZE = 8;

    private Task8() {
    }

    public static boolean knightBoardCapture(int[][] chessBoard) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (chessBoard[i][j] == 1 && (
                    checkCoordinates(i - 2, j - 1, chessBoard)
                        || checkCoordinates(i - 1, j - 2, chessBoard)
                        || checkCoordinates(i - 2, j + 1, chessBoard)
                        || checkCoordinates(i + 1, j - 2, chessBoard)
                        || checkCoordinates(i + 2, j - 1, chessBoard)
                        || checkCoordinates(i - 1, j + 2, chessBoard)
                        || checkCoordinates(i + 2, j + 1, chessBoard)
                        || checkCoordinates(i + 1, j + 2, chessBoard)
                )) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkCoordinates(int x, int y, int[][] array) {
        return x >= 0 && y >= 0 && x < SIZE && y < SIZE && array[x][y] == 1;
    }
}
