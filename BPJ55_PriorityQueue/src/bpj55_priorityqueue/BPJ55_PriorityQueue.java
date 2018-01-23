/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpj55_priorityqueue;

/**
 *
 * @author kell-gigabyte
 */
public class BPJ55_PriorityQueue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HeapPriorityQueue hpq = new HeapPriorityQueue();
        Integer iw;
        iw = 8;
        hpq.enqueue(iw);
        iw = 2;
        hpq.enqueue(iw);
        iw = 1;
        hpq.enqueue(iw);
        iw = 9;
        hpq.enqueue(iw);
        iw = 5;
        hpq.enqueue(iw);
        iw = 4; 
        hpq.enqueue(iw);
        System.out.println("");
        while (!hpq.isEmpty()) {
            System.out.println(hpq.dequeue()); //Prints in sequence 1, 2, 4, 5, 8, 9
        }
    }

}
