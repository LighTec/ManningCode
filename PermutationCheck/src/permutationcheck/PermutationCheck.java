/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutationcheck;

import java.util.ArrayList;

/**
 *
 * @author kell-gigabyte
 */
public class PermutationCheck {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 1, 2, 2, 3, 3};
        int[] arr4 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 2, 2, 3, 3};
        int[] arr2 = {4, 5, 7, 3, 3, 2, 4, 6, 3, 2, 4, 6, 5, 4, 3};
        int[] arr3 = {4, 3, 5, 6};

        System.out.println(arePermutations(arr1, arr4)); //true
        System.out.println(arePermutations(arr1, arr2)); //false
        System.out.println(arePermutations(arr1, arr3)); //false
    }

    public static boolean arePermutations(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            //System.out.println("non-similar length");
            return false;
        }
        ArrayList<Integer> arrList1 = new ArrayList<>();
        ArrayList<Integer> arrList2 = new ArrayList<>();

        for (int index = 0; index < arr1.length; index++) { //add ints to an Integer ArrayList for both
            arrList1.add(arr1[index]);
        }
        for (int index = 0; index < arr2.length; index++) {
            arrList2.add(arr2[index]);
        }

        for (int i = 0; i < arrList1.size(); i++) {
            int k;
            int thisInt = arrList1.get(i);
            //System.out.println("matching int: " + thisInt);
            boolean remInt = false;
            for (k = 0; k < arrList2.size(); k++) {
                int checkInt = arrList2.get(k);
                if (checkInt == thisInt) {
                    //System.out.println("match found, " + thisInt);
                    remInt = true;
                    break;
                }
                //System.out.println("current match int: " + checkInt);
            }
            if (!remInt) {
                //System.out.println("cannot find 2 of the same");
                return false;
            }
            arrList2.remove(k);
        };
        return true;
    }

}
