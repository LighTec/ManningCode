/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpj40_multikeysort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author kell-gigabyte
 */
public class BPJ40_MultiKeySort {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner txtIn = new Scanner(new File("Names_ages.txt"));
        int indx = -1;
        String text[] = new String[1000];
        while (txtIn.hasNext()) {
            indx++;
            text[indx] = txtIn.nextLine();
           // System.out.println(text[indx]);
        }
        txtIn.close();
        NameAge PeopleArr[] = new NameAge[indx];
        for (int i = 0; i < indx; i++) {
            //System.out.println(text[i]);
            NameAge tempObj = new NameAge(text[i]);
            PeopleArr[i] = tempObj;
        }
        sort(PeopleArr);
        
    }

    public static void sort(NameAge PeopleArr[]) {
         NameAge min;
                int minIndex;
        for (int i = 0; i < PeopleArr.length; ++i) {
            min = PeopleArr[i];
            minIndex = i;
            for (int j = i + 1; j < PeopleArr.length; ++j) // Find minimum
            {
                if (PeopleArr[j].getName().compareTo(min.getName()) < 0) //salient feature
                {
                    min = PeopleArr[j];
                    minIndex = j;
                }
            }
            PeopleArr[minIndex] = PeopleArr[i]; // swap
            PeopleArr[i] = min;
        }
        
         for (int i = 0; i < PeopleArr.length; ++i) {
            min = PeopleArr[i];
            minIndex = i;
            for (int j = i + 1; j < PeopleArr.length; ++j) // Find minimum
            {
                if (PeopleArr[j].getName().compareTo(min.getName()) == 0 && PeopleArr[j].getAge() < min.getAge()) //salient feature
                {
                    min = PeopleArr[j];
                    minIndex = j;
                }
            }
            PeopleArr[minIndex] = PeopleArr[i]; // swap
            PeopleArr[i] = min;
        }
        
           for(int i = 0; i < PeopleArr.length; i++){
            System.out.println(PeopleArr[i].toString());
        }
    }

}



/*                                      selection sorting for ages within NameAge
        NameAge min;
                int minIndex;
        for (int i = 0; i < PeopleArr.length; ++i) {
            min = PeopleArr[i];
            minIndex = i;
            for (int j = i + 1; j < PeopleArr.length; ++j) // Find minimum
            {
                if (PeopleArr[j].getAge() < min.getAge()) //salient feature
                {
                    min = PeopleArr[j];
                    minIndex = j;
                }
            }
            PeopleArr[minIndex] = PeopleArr[i]; // swap
            PeopleArr[i] = min;
        }
        
        for(int i = 0; i < PeopleArr.length; i++){
            System.out.println(PeopleArr[i].toString());
        }
        */