package com.company;

public class search2dMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0) {
            return false;
        }

        boolean solution = false;

        int rows = matrix.length;
        int columns = matrix[0].length;

        int topRow = 0;
        int bottomRow = rows - 1;

        while (topRow <= bottomRow) {
            int targetRow = (topRow + bottomRow) / 2;
            if (target > matrix[targetRow][columns-1]) {
                topRow = targetRow + 1;
            } else if(target < matrix[targetRow][0]) {
                bottomRow = targetRow - 1;
            } else {
                break;
            }
        }

        if(topRow > bottomRow) {
            return false;
        }

            int targetRow = (topRow + bottomRow) / 2;
            int left = 0;
            int right = columns-1;

            while(left <= right) {
                int middle = (left + right) / 2;
                if (target > matrix[targetRow][middle]) {
                    left = middle + 1;
                } else if(target < matrix[targetRow][middle]) {
                    right = middle - 1;
                } else if(target == matrix[targetRow][middle]){
                    solution = true;
                    break;
                }
            }


        return solution;

    }

}
