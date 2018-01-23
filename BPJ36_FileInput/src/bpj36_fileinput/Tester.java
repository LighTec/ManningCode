/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpj36_fileinput;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author kell-gigabyte
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner kbIn = new Scanner(System.in);
        String textInput = "";
        boolean itWorked = false;
        while (!itWorked) {
            System.out.println("Enter the file name here, or enter in 'exit' to quit this program.");
            textInput = kbIn.next();
            if (textInput.equals("exit")) {
                System.out.println("It did not work");
                break;
            }
            try {
                FileInput.readTheFile(textInput);
                itWorked = true;
            } catch (IOException e) {
                itWorked = false;

            }
            if (itWorked) {
                System.out.println("\nIt Worked");
            }
        }

    }

}
