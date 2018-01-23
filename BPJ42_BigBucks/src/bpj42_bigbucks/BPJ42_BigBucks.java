/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpj42_bigbucks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author kell-gigabyte
 */
public class BPJ42_BigBucks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<BankAccount> accounts = new ArrayList<>();

        while (true) {
            System.out.print("\nPlease enter the name whom the account belongs. (\"Exit\" to abort) ");
            Scanner sc = new Scanner(System.in);
            String name = sc.next();
            if(name.equals("Exit") || name.equals("exit")){
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
        
        while(iter.hasNext()){
            BankAccount iterAccount = (BankAccount)iter.next();
            if(iterAccount.balance > highestBalance.balance){
                highestBalance = iterAccount;
            }
            
        }
        
        System.out.println("\nThe account with the largest balance belongs to " + highestBalance.name + ".");
         System.out.println("The account is " + highestBalance.balance);
    }

}
