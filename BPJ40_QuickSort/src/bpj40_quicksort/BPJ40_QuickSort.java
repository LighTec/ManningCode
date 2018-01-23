/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpj40_quicksort;

/**
 *
 * @author kell-gigabyte
 */
public class BPJ40_QuickSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int theArray[] = {4, 2, 5, 1, 3, 18, 0, 9, 6};
        sort(theArray, 0, theArray.length - 1);
        for (int j = 0; j < theArray.length; j++) {
            System.out.print(theArray[j] + " ");
        }
        System.out.println(" ");
    }

    public static void sort(int a[], int left, int right) {
        if (left >= right) {
            return;
        }
        int k = left;
        int j = right;
        int pivotValue = a[(left + right) / 2]; // salient feature
        while (k < j) {
            while (a[k] < pivotValue) //salient feature (pivot point)
            {
                k++;
            }
            while (pivotValue < a[j]) {
                j--;
            }
            if (k <= j) {
                int temp = a[k]; //swap a[k] and a[j]
                a[k] = a[j];
                a[j] = temp;
                k++;
                j--;
            }
        }
        sort(a, left, j); //salient feature (recursion)
        sort(a, k, right);
    }

}
