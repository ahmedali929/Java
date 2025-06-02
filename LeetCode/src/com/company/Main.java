package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int[][] matrix = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        int target = 3;

        System.out.println(search2dMatrix.searchMatrix(matrix, target));

    }
}
