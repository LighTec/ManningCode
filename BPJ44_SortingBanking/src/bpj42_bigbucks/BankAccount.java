/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpj42_bigbucks;

/**
 *
 * @author kell-gigabyte
 */
public class BankAccount implements Comparable<BankAccount>{

    public BankAccount(String nm, double amt) {
        name = nm;
        balance = amt;
    }
/**
 * deposits dp amount to the account.
 * @param dp 
 */
    public void deposit(double dp) {
        balance = balance + dp;
    }

    /**
     * withdraws wd amount from the account.
     * @param wd 
     */
    public void withdraw(double wd) {
        balance = balance - wd;
    }
    public String name;
    public double balance;

    /**
     *  Compares the balance of two accounts. -1 if the other account is higher, 1 if not, and 0 if both are the same.
     * @param otherAccount
     * @return
     */
    @Override
    public int compareTo(BankAccount otherAccount) {
        return name.compareTo(otherAccount.name);
    }
    
    @Override
    public String toString(){
        String temp = "" +  this.name + " >>> " + this.balance;
        return temp;
    }
}

/*
@Override
    public int compareTo(BankAccount otherAccount) {        //Smallest balance first
        int retValue;
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
*/
