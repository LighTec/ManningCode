/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpj50_binarysearchlist;

/**
 *
 * @author kell-gigabyte
 */
public class BPJ50_BinarySearchList {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int i[] = {-7, 15, 21, 22, 43, 49, 51, 67, 78, 81, 84, 89, 95, 97};
        int m[] = {97, 95, 89, 84, 81, 78, 67, 51, 49, 43, 22, 21, 15, -7};
        //System.out.println(binarySearch(i, 22)); //prints 3
        //System.out.println(binarySearch(i, 89)); //prints 11
       // System.out.println(binarySearch(i, -100)); //prints -1
       // System.out.println(binarySearch(i, 72)); //prints -1
      //  System.out.println(binarySearch(i, 102)); //prints -1
        System.out.println(descendingBinarySearch(m, 22)); //prints 10
        System.out.println(descendingBinarySearch(m, 89)); //prints 2
        System.out.println(descendingBinarySearch(m, -100)); //prints -1
        System.out.println(descendingBinarySearch(m, 72)); //prints -1
        System.out.println(descendingBinarySearch(m, 102)); //prints -1
    }
//Look for srchVal in the a[] array and return the index of where it’s found
//Return –1 if not found

    private static int binarySearch(int a[], int srchVal) {
        int lb = 0;
        int ub = a.length - 1;
        while (lb <= ub) {
            int mid = (lb + ub) / 2;
            if (a[mid] == srchVal) {
                return mid;
            } else if (srchVal > a[mid]) {
                lb = mid + 1; //set a new lowerbound
            } else {
                ub = mid - 1; //set a new upper bound
            }
        }
        return -1; //srchVal not found
    }
    
     private static int descendingBinarySearch(int a[], int srchVal) {
        int lb = 0;
        int ub = a.length - 1;
        while (lb <= ub) {
            int mid = (lb + ub) / 2;
            if (a[mid] == srchVal) {
                return mid;
            } else if (srchVal < a[mid]) {
                lb = mid + 1; //set a new lowerbound
            } else {
                ub = mid - 1; //set a new upper bound
            }
        }
        return -1; //srchVal not found
    }
}
