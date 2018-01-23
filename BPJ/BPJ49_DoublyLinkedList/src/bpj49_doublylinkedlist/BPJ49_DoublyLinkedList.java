/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpj49_doublylinkedlist;

import java.util.Scanner;

/**
 *
 * @author kell-gigabyte
 */
public class BPJ49_DoublyLinkedList {
    
    static StackerString stacker;

    public static void main(String[] args) {
        stacker = new StackerString();  
        Scanner kbin = new Scanner(System.in);
        String s = "";
        while (true) {
            System.out.print("\nEnter Number, math operation (+,-,*, or /), or Q to quit: ");
            s = kbin.next();
            if (s.equals("Q") || s.equals("q")) {
                break;
            } else {
               double last, first, answer;
                switch (s) {
                    case "/":
                        last = Double.parseDouble(stacker.pop());
                         first = Double.parseDouble(stacker.pop());
                         answer = first / last;
                        stacker.push(Double.toString(answer));
                        break;
                    case "*":
                        last = Double.parseDouble(stacker.pop());
                         first = Double.parseDouble(stacker.pop());
                         answer = first * last;
                        stacker.push(Double.toString(answer));
                        break;
                    case "+":
                        last = Double.parseDouble(stacker.pop());
                         first = Double.parseDouble(stacker.pop());
                         answer = first + last;
                        stacker.push(Double.toString(answer));
                        break;
                    case "-":
                         last = Double.parseDouble(stacker.pop());
                         first = Double.parseDouble(stacker.pop());
                         answer = first - last;
                        stacker.push(Double.toString(answer));
                        break;
                    default:
                        stacker.push(s);
                        break;
                }
            }
        }
        System.out.println("The answer is " + stacker.pop());
    }
}
