package com.thealgorithms.maths;

import java.util.Scanner;

/*A magic square of order n is an arrangement of distinct n^2 integers,in a square, such that the n
numbers in all rows, all columns, and both diagonals sum to the same constant. A magic square
contains the integers from 1 to n^2.*/
public final class MagicSquare {
    private MagicSquare() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a number: ");
        int num = sc.nextInt();
        if (isInvalidMagicSquareSize(num)) {
            System.out.print("Input number must be odd and >0");
            System.exit(0);
        }

        int[][] magicSquare = new int[num][num];

        int rowNum = num / 2;
        int colNum = num - 1;
        magicSquare[rowNum][colNum] = 1;

        for (int i = 2; i <= num * num; i++) {
            int nextRow = (rowNum - 1 + num) % num;
            int nextCol = (colNum + 1) % num;

            if (magicSquare[nextRow][nextCol] == 0) {
                rowNum = nextRow;
                colNum = nextCol;
            } else {
                colNum = (colNum - 1 + num) % num;
            }
            magicSquare[rowNum][colNum] = i;
        }

        printMagicSquare(magicSquare, num);

        sc.close();
    }

    private static boolean isInvalidMagicSquareSize(int num) {
        boolean isEvenNumber = (num % 2 == 0);
        boolean isNonPositive = (num <= 0);
        return isEvenNumber || isNonPositive;
    }


    public static void printMagicSquare(int[][] magicSquare, int num) {
        // print the square
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (magicSquare[i][j] < 10) {
                    System.out.print(" ");
                }
                if (magicSquare[i][j] < 100) {
                    System.out.print(" ");
                }
                System.out.print(magicSquare[i][j] + " ");
            }
            System.out.println();
        }
    }
}
