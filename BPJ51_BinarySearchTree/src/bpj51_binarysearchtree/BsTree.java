/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpj51_binarysearchtree;

/**
 *
 * @author kell-gigabyte
 */
public class BsTree {

    public BsTree(Comparable d) {
        theData = d;
        leftNode = null; //This and next line could be omitted,
        rightNode = null; //they are automatically null.
    }

    public BsTree addNode(Comparable d) {
        if (d.compareTo(theData) > 0) { //d should be inserted somewhere in the branch to the right
            if (rightNode != null) //right node exists, go down that branch, look for place to put it
            {
                rightNode.addNode(d);
            } else {
                rightNode = new BsTree(d); //Create new rightNode, store d in it
            }
        } else { //d should be inserted somewhere in the branch to the left
            if (leftNode != null) //left node exists, go down that branch, look for place to put it
            {
                leftNode.addNode(d);
            } else {
                leftNode = new BsTree(d); //Create a new leftNode, store d in it
            }
        }
        return this;
    }
    private Comparable theData;
    private BsTree leftNode, rightNode;

    public void traverseAndPrint() //Use with BsTree class on previous page.
    {
        if (leftNode != null) {
            leftNode.traverseAndPrint();
        }
        System.out.println(theData);
        if (rightNode != null) {
            rightNode.traverseAndPrint();
        }
    }
}
