/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KTviewController;

import KTmodels.Account;

/**
 *
 * @author Kell
 */
public class ViewOutputs extends DrawnView {

    
    public void refresh(double num, int op, int ID, String name) {
        Account temporaryAccount = accountManager.getAccount(ID);
        if (temporaryAccount == null){
            System.out.println("No account found");
            return;
        }
        if(op == 0){
            accountManager.editAccount(0, num, "", temporaryAccount.getID());
        }else if( op == 1){ 
            accountManager.editAccount(1, num, "", temporaryAccount.getID());
        }else if(op == 2){
            accountManager.editAccount(2, 1, name, temporaryAccount.getID());
        }else{
            System.err.println("System operation error.");
        }
        
        String balance = "" + temporaryAccount.getBalance();
        String acctName = temporaryAccount.getAccountName();
        String accountID = Integer.toString(temporaryAccount.getID());
        
        acctID.setText(accountID);
        Balance.setText(balance);
        System.err.println("frame");
    }      
    
    
}
