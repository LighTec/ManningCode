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
public interface PriorityQueue {

    void enqueue(Object obj); // sometimes called add

    Object dequeue(); // sometimes called removeRoot or removeMin

    Object peek();

    boolean isEmpty();
}
