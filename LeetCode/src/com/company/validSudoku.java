package com.company;

import java.util.HashSet;

public class validSudoku {

    public static void main(String[] args) {

    }

    public static boolean isValidSudokuBoard(char[][] board) {

        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currentCharacter = board[i][j];
                if (currentCharacter != '.') {
                    if (!seen.add(currentCharacter + " found in row " + i) ||
                    !seen.add(currentCharacter + " found in column " + j) ||
                    !seen.add(currentCharacter + " found in grid " + "(" + i/3 + "," + j/3 + ")")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
