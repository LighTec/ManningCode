/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpj49_doublylinkedlist;

import java.util.LinkedList;

/**
 *
 * @author kell-gigabyte
 */
public class Stacker implements Stackerface{

    private LinkedList<Double> list = new LinkedList<>();
    
    public Stacker(){
    }
    
    @Override
    public void push(double d) {
        list.add(d);
    }

    @Override
    public double pop() {
        return list.removeLast();
    }

    @Override
    public double peek() {
        return list.getLast();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void clear() {
       list.clear();
    }
    
}
