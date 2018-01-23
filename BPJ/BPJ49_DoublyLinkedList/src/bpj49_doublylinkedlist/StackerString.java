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
public class StackerString {

    private LinkedList<String> list = new LinkedList<>();
    
    public StackerString(){
    }
    
    public void push(String d) {
        list.add(d);
    }

    public String pop() {
        return list.removeLast();
    }

    public String peek() {
        return list.getLast();
    }

    public int size() {
        return list.size();
    }

    public void clear() {
       list.clear();
    }
    
}
