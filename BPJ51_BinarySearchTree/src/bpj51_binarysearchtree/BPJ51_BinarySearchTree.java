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
public class BPJ51_BinarySearchTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ///the first integer in the tree is used to create the object
        BST bstObj = new BST(50);
        bstObj.addNode(56);
        bstObj.addNode(52);
        bstObj.addNode(25);
        bstObj.addNode(74);
        bstObj.addNode(54);
        bstObj.traverseAndPrint(bstObj.rootNode);

        System.out.println(bstObj.find(74)); //This is one it will find...prints a true
        System.out.println(bstObj.find(13)); //This is one it won't find...prints a false
    }

}
