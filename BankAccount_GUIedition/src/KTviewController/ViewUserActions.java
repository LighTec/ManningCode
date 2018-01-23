/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KTviewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Kell
 */
public class ViewUserActions extends ViewOutputs {

    /*
     * Step 1 of 2 for writing user actions.
     * -------------------------------------
     *
     * User actions are written as private inner classes that implement
     * ActionListener, and override the actionPerformed method.
     *
     * Use the following as a template for writting more user actions.
     */
    
    
    
    /*
    private class SubNum implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String num1 = number1.getText(); // get text from view
            String num2 = number2.getText();
            CalcSimple.setNum1(num1); // updates num1
            CalcSimple.setNum2(num2); // updates num2
            CalcSimple.setOperation('-'); //updates the operation performed
            numResult(); // tell view to update
        }
               // example code
    }
    */
    private class deposit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.out.println("dep");
            String num = numberEnter.getText();
            String IDStr = acctID.getText();
            int ID = Integer.parseInt(IDStr);
            double trueNum = Double.parseDouble(num);
            refresh(trueNum, 1, ID, "");
        }
    }
    
    
        private class withdraw implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.out.println("with");
            String num = numberEnter.getText();
            String IDStr = acctID.getText();
            int ID = Integer.parseInt(IDStr);
            double trueNum = Double.parseDouble(num);
            refresh(trueNum, 0, ID, "");
        }
        
        private class nameChg implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.out.println("name");
            String IDStr = acctID.getText();
            int ID = Integer.parseInt(IDStr);
            String name
            refresh(0.00, 2, ID, );
        }
    }

    /*
     * ViewUserActions constructor used for wiring user actions to GUI elements
     */
    public ViewUserActions() {
        /*
         * Step 2 of 2 for writing user actions.
         * -------------------------------------
         *
         * Once a private inner class has been written for a user action, you
         * can wire it to a GUI element (i.e. one of GUI elements you drew in
         * the DrawnView class and which you gave a memorable public variable
         * name!).
         *
         * Use the following as a template for wiring more user actions.
         */
        //AddButton.addActionListener(new AddNum());
        //SubtractButton.addActionListener(new SubNum());  //more examples
        Withdraw.addActionListener(new withdraw());
        Deposit.addActionListener(new deposit());
        AcctChg.addActionListener(new nameChg());
    }
    }