/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpj42_bigbucks;

import java.util.Comparator;

/**
 *
 * @author kell-gigabyte
 */
public class BankAccountCompare implements Comparator<BankAccount>{

    @Override
    public int compare(BankAccount firstAccount, BankAccount otherAccount) {
         int retValue;
         double balance = firstAccount.balance;
        if (balance < otherAccount.balance) {
            retValue = -1;
        } else {
            if (balance > otherAccount.balance) {
                retValue = 1;
            } else {
                retValue = 0;
            }
        }
        return retValue;
    }
    
}
