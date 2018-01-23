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
public class BstNode {

    public BstNode(int i) //Constructor
    {
        leftNode = null;
        rightNode = null;
        intData = i;
    }
    public int intData;
    public BstNode leftNode;
    public BstNode rightNode;

}
