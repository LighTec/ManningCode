/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpj49_contestproblem;

import java.util.LinkedList;

/**
 *
 * @author kell-gigabyte
 */
public class BigStack {

    public BigStack() {
        lkdList = new LinkedList();
    }

    public void push(int x) {
        lkdList.addLast(new Integer(x));
    }

    public int pop() {
        return (Integer) lkdList.removeFirst();
    }

    public int peek() {
        return (Integer) lkdList.getFirst();
    }

    private LinkedList lkdList;

}
