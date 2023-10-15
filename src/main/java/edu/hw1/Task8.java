package edu.hw1;

public class Task8 {

    private static final int SIZE = 8;

    private Task8() {
    }

    public static boolean knightBoardCapture(int[][] chessBoard) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isKnightPresent(chessBoard, i, j) && canKnightEatSomeone(chessBoard, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isCoordinatesChecked(int x, int y, int[][] array) {
        return x >= 0 && y >= 0 && x < SIZE && y < SIZE && array[x][y] == 1;
    }

    private static boolean isKnightPresent(int[][] chessBoard, int i, int j) {
        return chessBoard[i][j] == 1;
    }

    private static boolean canKnightEatSomeone(int[][] chessBoard, int i, int j) {
        return isCoordinatesChecked(i - 2, j - 1, chessBoard)
            || isCoordinatesChecked(i - 1, j - 2, chessBoard)
            || isCoordinatesChecked(i - 2, j + 1, chessBoard)
            || isCoordinatesChecked(i + 1, j - 2, chessBoard)
            || isCoordinatesChecked(i + 2, j - 1, chessBoard)
            || isCoordinatesChecked(i - 1, j + 2, chessBoard)
            || isCoordinatesChecked(i + 2, j + 1, chessBoard)
            || isCoordinatesChecked(i + 1, j + 2, chessBoard);
    }
}
