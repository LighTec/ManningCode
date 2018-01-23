/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bpj49_contestproblem;

/**
 *
 * @author kell-gigabyte
 */
public class BPJ49_ContestProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BigStack b = new BigStack();
        b.push(1);
        b.push(2);
        b.push(3);
        b.push(4);
        b.push(5);
        
        b.pop();
        System.out.println(b.pop());
        int s = b.pop();
    }

}
