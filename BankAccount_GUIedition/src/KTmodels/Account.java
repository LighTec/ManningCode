/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KTmodels;

/**
 *
 * @author Kell
 */
public class Account {
    
    private double balance;
    private String accountName;
    private int accountNumber;
    
    public Account(String name, int num){
        accountNumber = num;
        name = accountName;
    }
    
    public int getID(){
        return accountNumber;
    }
    
    public String getAccountName(){
        return accountName;
    }
    
    public double getBalance(){
        return balance;
    }
    
    public void resetName(String name){
        accountName = name;
    }
    
    public void depositBalance(double addNum){
        balance = addNum + balance;
    }
    
    public void withdrawBalance(double subNum){
        balance = balance - subNum;
    }
    
    
}
