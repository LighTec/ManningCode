/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exceptiontester;

/**
 *
 * @author kell-gigabyte
 */
public class ExceptionTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int count = 0;
        while(true){
        double d = Math.random() * 1000000;
       // System.out.println(d);
        if(d < 9000){
            GeorgeTooBallzDeep g = new GeorgeTooBallzDeep("It has to be over 9000, first iteration this is false is " + count);
            throw g;
        }
        count++;
        }
    }

}
