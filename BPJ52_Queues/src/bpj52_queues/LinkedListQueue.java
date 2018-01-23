/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpj52_queues;

import java.util.LinkedList;

/**
 *
 * @author kell-gigabyte
 */
public class LinkedListQueue implements Queue {

    public LinkedListQueue() //constructor
    {
        lst = new LinkedList();
    }

    public void enqueue(Object obj) {
        lst.addLast(obj);
    }

    public Object dequeue() {
        return lst.removeFirst();
    }

    public Object peekFront() {
        return lst.getFirst();
    }

    public boolean isEmpty() {
        return lst.isEmpty();
    }
    private LinkedList lst; // state variable
}
