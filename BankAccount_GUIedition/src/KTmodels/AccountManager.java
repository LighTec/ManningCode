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
public class AccountManager {

    private Account[] accountArr;
    private int accountNum;

    public AccountManager() {
        accountArr = new Account[10000];
        this.accountNum = 0;
    }

    public Account getAccount(int ID) {
        for (int chk = 0; chk >= accountNum; chk++) {
            Account accountCheck = accountArr[chk];
            if (accountCheck.getID() == ID) {
                System.out.println("getting account at " + ID + ", name of " + accountCheck.getAccountName());
                return accountCheck;
            }
        }
        System.err.println("Account ID not found");
        return null;
    }

    public void editAccount(int op, double transfer, String name, int ID) {
        Account newAccount = getAccount(ID);
        if(op == 0){ //Withdraw
            newAccount.withdrawBalance(transfer);
            System.out.println("Withdrawl " + transfer);
            
        }
        if(op == 1){ //Deposit
            newAccount.depositBalance(transfer);
            System.out.println("Deposit " + transfer);
            
        }
        if(op == 2){ //New Name
            newAccount.resetName(name);
            System.out.println("New name is " + name);
            
        }
        commitAccount(ID, newAccount);
    }
    
    public void commitAccount(int ID, Account newAccount){
        accountArr[ID] = newAccount;
        System.out.println("Editing account at ID " + ID);
    }

    public void newAccount(String name) {
        Account tempAccount = new Account(name, accountNum);
        System.out.println("Creating new Account at " + accountNum);
        commitAccount(accountNum ,tempAccount);
        accountNum++;
    }
}
