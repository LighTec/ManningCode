/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpj34_matrixmult;

/**
 *
 * @author kell-gigabyte
 */
public class MatrixMult {

    public static int[][] mult(int[][] a, int[][] b) {
        int[][][] rawResult = new int[a.length][b[0].length][a[0].length];
        int[][] addedResult = new int[a.length][b[0].length];
        
        for (int r = 0; r < a.length; r++) {
            //System.out.println("loop to next row @ " + r);
            for (int c = 0; c < b[0].length; c++) {      // loops for each matrix multiplication
                //System.out.println("loop to next column @ " + c);
                // loops for the actual multiplication
                int k = 0;
                for (int i = 0; i < a[0].length; i++) {
                    //System.out.println("loop to next matrix Multiplication starting @ row coordinates " + r + "," + i);
                    rawResult[r][c][i] = a[r][i] * b[k][c];
                    //System.out.println("Result of array a @ " + r + "," + i + " with a value of " + a[r][i] + " multiplied by array b @ " + c + "," + k + " with a value of " + b[k][c] + " results in " + rawResult[r][c][i]);
                    k++;
                }
            }
        }
       // System.out.println("Now adding up the 3D array to turn into a 2D array with relevant results");
        for (int r = 0; r < a.length; r++) {
            for (int c = 0; c < b[0].length; c++) {
                int sum = 0;
                for (int addLoop = 0; addLoop < a[0].length; addLoop++) {
                    sum += rawResult[r][c][addLoop];
                }
                addedResult[r][c] = sum;
                //System.out.println("Results of Matrix Multiplication @ coordinates " + r + "," + c + " is equal to " + addedResult[r][c]);
            }
        }
        //System.out.println("Matrix Multiplication complete.");
        return addedResult;
    }
}
