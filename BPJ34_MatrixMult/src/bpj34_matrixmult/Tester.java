/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpj34_matrixmult;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author kell-gigabyte
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {    //There has to be a better way to do this, going to run thru it twice, once to define the shape of the array then fill it

        int matrix1Rows = -1;
        int matrix1Columns = -1;
        int matrix2Rows = -1;
        int matrix2Columns = -1;

        int[][] a;
        int[][] b;

        try {
            boolean firstMatrix;
            boolean firstRow = true;

            Scanner MatrixIn = new Scanner(new File("MatrixInput.txt"));
            String currentStr = MatrixIn.nextLine();    // assumes it is matrix
            firstMatrix = true;
            currentStr = MatrixIn.nextLine();   //assumes it is row
            matrix1Rows = 1;
            matrix1Columns = 0;
            while (MatrixIn.hasNext()) {
                currentStr = MatrixIn.nextLine();
                //System.out.println(currentStr);
                if (currentStr.equals("matrix")) {
                    //System.out.println("switching to matrix 2 define");
                    firstMatrix = false;
                    currentStr = MatrixIn.next(); //this one holds "row"
                    currentStr = MatrixIn.next(); // grabs the first number of the second array
                    matrix2Rows = 1;
                    firstRow = true;
                }
                if (firstMatrix) {
                    if (firstRow) {
                        if (currentStr.equals("row")) {
                            firstRow = false;
                            matrix1Rows++;
                        } else if (firstRow) {
                            matrix1Columns++;
                        }
                    } else if (!firstRow) {
                        if (currentStr.equals("row")) {
                            matrix1Rows++;
                        }
                    }
                } else if (firstRow) {
                    if (currentStr.equals("row")) {
                        firstRow = false;
                        matrix2Rows++;
                    } else if (firstRow) {
                        matrix2Columns++;
                    }
                } else if (!firstRow) {
                    if (currentStr.equals("row")) {
                        matrix2Rows++;
                    }
                }
            }
            //System.out.println("r1:" + matrix1Rows + " c1:" + matrix1Columns + " r2:" + matrix2Rows + " c2:" + matrix2Columns);
            MatrixIn.close();
        } catch (FileNotFoundException e) {
            System.err.println(" File Not found, and matrix size defnintions not started. Please enter an actual file path.       " + e);
        }
        try {
            a = new int[matrix1Rows][matrix1Columns];
            b = new int[matrix2Rows][matrix2Columns];
            //System.out.println("array initialized");
            int row = 0;
            int column = 0;
            try {
                Scanner MatrixIn2 = new Scanner(new File("MatrixInput.txt"));
                //System.out.println("MatrixIn2 Scanner started");
                String currentStr = MatrixIn2.next();  //We don't need the first two tokens, because we assume they want
                currentStr = MatrixIn2.next();             // to get the first matrix starting at row 0
                while (MatrixIn2.hasNext()) {
                    //System.out.println("Looping through to get numbers");
                    currentStr = MatrixIn2.next();
                    if (currentStr.equals("matrix")) {
                        //System.out.println("changing over to second array");
                        break;
                    } else if (currentStr.equals("row")) {
                        column = 0;
                        row++;
                    } else {
                        int currentInt = Integer.parseInt(currentStr);
                        //System.out.println("Trying to insert number " + currentInt + " into array 1 @ coordinates " + row + "," + column + "  1m");
                        a[row][column] = currentInt;
                        column++;
                    }

                }
                column = 0;
                row = 0;
                currentStr = MatrixIn2.next();  //We don't need the first two tokens, because we assume they want
                currentStr = MatrixIn2.next();             // to get the first matrix starting at row 0
                while (MatrixIn2.hasNext()) {
                    currentStr = MatrixIn2.next();
                    if (currentStr.equals("row")) {
                        column = 0;
                        row++;
                    } else {
                        int currentInt = Integer.parseInt(currentStr);
                        //System.out.println("Trying to insert number " + currentInt + " into array 2 @ coordinates " + row + "," + column + "  1m");
                        b[row][column] = currentInt;
                        column++;
                    }
                }
                //System.out.println("Looping through to get numbers");
                MatrixIn2.close();

                int[][] result = MatrixMult.mult(a, b);
                for (int r = 0; r < result.length; r++) {
                    for (int z = 0; z < result[0].length; z++) {
                        System.out.print(result[r][z] + "\t");
                    }
                    System.out.print("\n");
                }

                /*
                int[][] c = {{1, 2, -2, 0}, {-3, 4, 7, 2}, {6, 0, 3, 1}};
                int[][] d = {{-1, 3}, {0, 9}, {1, -11}, {4, -5}};
                int[][] result2 = MatrixMult.mult(a, b);
                for (int r = 0; r < result2.length; r++) {
                    for (int z = 0; z < result2[0].length; z++) {
                        System.out.print(result2[r][z] + "\t");
                    }
                    System.out.print("\n");
                }
                */

            } catch (FileNotFoundException g) {
                System.err.println(" File Not found, and matrix multiplication not started. Please enter an actual file path.       " + g);
            }
        } catch (NegativeArraySizeException f) {
            System.err.println("Array sizes not found in the first iteration of the text, please check the text file is properly formatted.  \t\t" + f);
        }

    }
}
