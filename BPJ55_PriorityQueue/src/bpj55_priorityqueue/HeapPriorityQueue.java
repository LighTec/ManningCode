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
public class HeapPriorityQueue implements PriorityQueue {

    public HeapPriorityQueue() //constructor
    {
        obj = new Object[1000];
    }

    @Override
    public boolean isEmpty() {
        return numObjects <= 0;
    }

    @Override
    public Object peek() {
        return obj[0];
    }

    @Override
    public void enqueue(Object ob) {
        numObjects++;
        obj[numObjects] = ob;
        reheapUp();
    }

    @Override
    public Object dequeue() {
        Object ob = obj[0];
        obj[0] = obj[numObjects];
        numObjects--;
        reheapDown();
        return ob;
    }

    private void reheapDown() {
//The value in the root moves down the heap until it falls into its
//proper place.
//At each step as it moves down, it is swapped with its smaller child.
        Object root = obj[1];
        int parentIndx = 1;
        int childIndx = 2;
        while (childIndx <= numObjects) {
            if ((childIndx < numObjects)
                    && (((Comparable) obj[childIndx + 1]).compareTo(obj[childIndx]) < 0)) {
                childIndx++;
            }
            if (!(((Comparable) obj[childIndx]).compareTo(root) < 0)) {
                break;
            }
            obj[parentIndx] = obj[childIndx];
            parentIndx = childIndx;
            childIndx = parentIndx * 2;
        }
        obj[parentIndx] = root;
    }

    private void reheapUp() {
//The new node moves up the tree swapping places with its parent
//until it falls into place.
        Object lastLeaf = obj[numObjects];
        int childIndx = numObjects, parentIndx = childIndx / 2;
        System.out.println("Child index = " + childIndx + " Parent Index = " + parentIndx + " Last leaf is " + lastLeaf.toString());
        while ((parentIndx >= 1) && (((Comparable) lastLeaf).compareTo(obj[parentIndx]) < 0)) {
            System.out.println("Swapping " + obj[childIndx] + " into the position of " + obj[parentIndx]);
            obj[childIndx] = obj[parentIndx];
            childIndx = parentIndx;
            parentIndx /= 2;
        }
        obj[childIndx] = lastLeaf;
    }
    private Object obj[];
    private int numObjects = 0;
}
