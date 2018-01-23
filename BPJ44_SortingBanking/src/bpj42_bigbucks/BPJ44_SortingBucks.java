/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpj42_bigbucks;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author kell-gigabyte
 */
public class BPJ44_SortingBucks{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);
        String name;
        int j;
        //ArrayList<BankAccount> accounts = new ArrayList<>();
        BankAccount[] ba = new BankAccount[5];

        Scanner kbReader = new Scanner(System.in);

        for (j = 0; j < ba.length; j++) {
            System.out.print("Please enter the name to whom the account belongs. ");
            name = kbReader.next();

            boolean tryAgain = true;
            double deposit;
            do {
                tryAgain = false;
                System.out.print("Please enter the amount to deposit. ");
                try {
                    deposit = Double.parseDouble(kbReader.next());

                } catch (NumberFormatException e) {
                    tryAgain = true;
                    System.err.println("Deposit sum is not a number");
                    deposit = 0;
                }
            } while (tryAgain);
            ba[j] = new BankAccount(name, deposit);
        }

        kbReader.close();
        
        Arrays.sort(ba);
        
        for(BankAccount account: ba){
            System.out.println(account.toString());
        }
        System.out.println("\n\n");
        
        Comparator accountCompare = new BankAccountCompare();
        /*
        Arrays.sort(ba, accountCompare);            // Using a comparator

        for(BankAccount account: ba){
            System.out.println(account.toString());
        }
        */
        
        
        /*
        while (true) {
            System.out.print("\nPlease enter the name whom the account belongs. (\"Exit\" to abort) ");
            Scanner sc = new Scanner(System.in);
            name = sc.next();
            if (name.equals("Exit") || name.equals("exit")) {
                break;
            }
            boolean tryAgain;
            double deposit;
            do {
                tryAgain = false;
                System.out.print("Please enter the amount to deposit. ");
                try {
                    deposit = Double.parseDouble(sc.next());

                } catch (NumberFormatException e) {
                    tryAgain = true;
                    System.err.println("Deposit sum is not a number");
                    deposit = 0;
                }
            } while (tryAgain);
            accounts.add(new BankAccount(name, deposit));
        }
        Iterator iter = accounts.listIterator();

        BankAccount highestBalance = (BankAccount) iter.next();

        while (iter.hasNext()) {
            BankAccount iterAccount = (BankAccount) iter.next();
            if (iterAccount.balance > highestBalance.balance) {
                highestBalance = iterAccount;
            }

        }

        System.out.println("\nThe account with the largest balance belongs to " + highestBalance.name + ".");
        System.out.println("The account is " + highestBalance.balance);
         */
    }
}
