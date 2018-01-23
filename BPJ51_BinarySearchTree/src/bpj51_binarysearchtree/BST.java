/*
 * This program was designed for a arduino Uno, or any similar device that can communicate over 
 * serial USB.
 * ---------------------------------------------------------
 * This program is designed to have the arduino itself run custom code, so do not expect
 * that you can run this on any random arduino. The code required to get the arduino to work
 * can be found as a .ino file recognizable by the arduino IDE, within the zip package of this
 * program.
 */
package bpj51_binarysearchtree;

/**
 *
 * @author kell-gigabyte
 */
public class BST {

    public BST(int i) //constructor: Root node added at the time of creation of the tree
    {
        rootNode = new BstNode(i);
    }

    public void addNode(int i) {
        BstNode currentNode = rootNode;
        boolean finished = false;
        do {
            BstNode curLeftNode = currentNode.leftNode;
            BstNode curRightNode = currentNode.rightNode;
            int curIntData = currentNode.intData;
            if (i > curIntData) { //look down the right branch
                if (curRightNode == null) { //create a new node referenced with currentNode.rightNode
                    currentNode.rightNode = new BstNode(i);
                    finished = true;
                } else //keep looking by assigning a new current node one level down
                {
                    currentNode = curRightNode;
                }
            } else { //look down the left branch
                if (curLeftNode == null) { //create a new node referenced with currentNode.leftNode
                    currentNode.leftNode = new BstNode(i);
                    finished = true;
                } else { //keep looking by assigning a new current node one level down
                    currentNode = curLeftNode;
                }
            }
        } while (!finished);
    }
    BstNode rootNode;

    public void traverseAndPrint(BstNode currentNode) {
        System.out.print("data = " + currentNode.intData);
//To aid in your understanding, you may want to just ignore this
//indented portion and just print the integer. In that case, change the
//line above to a println instead of a print.
        if (currentNode.leftNode == null) {
            System.out.print(" left = null");
        } else {
            System.out.print(" left = " + (currentNode.leftNode).intData);
        }
        if (currentNode.rightNode == null) {
            System.out.print(" right = null");
        } else {
            System.out.print(" right = " + (currentNode.rightNode).intData);
        }
        System.out.println("");
        if (currentNode.leftNode != null) {
            traverseAndPrint(currentNode.leftNode);
        }
        if (currentNode.rightNode != null) {
            traverseAndPrint(currentNode.rightNode);
        }

    }
    
    public boolean find(int i) {
        BstNode currentNode = rootNode;
        boolean finished = false;
        do {
            BstNode curLeftNode = currentNode.leftNode;
            BstNode curRightNode = currentNode.rightNode;
            int curIntData = currentNode.intData;
            if (i > curIntData) { //look down the right branch
                if (curRightNode == null) { //create a new node referenced with currentNode.rightNode
                    finished = true;
                } else //keep looking by assigning a new current node one level down
                {
                    currentNode = curRightNode;
                }
            } else if(i < curIntData){ //look down the left branch
                if (curLeftNode == null) { //create a new node referenced with currentNode.leftNode
                    finished = true;
                } else { //keep looking by assigning a new current node one level down
                    currentNode = curLeftNode;
                }
            }else{
                return true;
            }
        } while (!finished);
        return false;
    }
}
