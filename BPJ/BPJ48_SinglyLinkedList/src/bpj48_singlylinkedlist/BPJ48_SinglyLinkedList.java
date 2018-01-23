/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpj48_singlylinkedlist;

/**
 *
 * @author kell-gigabyte
 */
public class BPJ48_SinglyLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        append(0, "Pump station");
        append(3050, "Hwy 35");
        append(4573, "Tank farm"); //3050 + 990 + 553 = 4573
        traverseAndPrint();
        System.out.println(" ******* now insert a node before old node 2 *******\n");
        insert(4040, "Cold Creek", 2); // 3050 + 990 = 4040
        traverseAndPrint();
    }

    public static void insert(int pos, String desc, int place) {
        if(place < 0){
            throw new RuntimeException("Place is negative, it cannot be negative for insert method. ");
        }
        if (place == 0) {
            PipelineNode newHead = new PipelineNode(pos, desc, headNode);
            headNode = newHead;
        } else {

            PipelineNode currentNode = headNode;
           for(int i = 0; i < place -1; i++){
               currentNode = currentNode.nextNode;
           }
                //System.err.println("Node Desc: " + currentNode.description);
                PipelineNode oldNextNode;
                    oldNextNode = currentNode.nextNode;
                    currentNode.nextNode = new PipelineNode(pos, desc, oldNextNode);
        }
    }

    public static void traverseAndPrint() {
        PipelineNode currentNode = headNode;
        int nodeNum = -1;
        do {
            nodeNum++;
            System.out.println("Node number: " + nodeNum);
            System.out.println("Position: " + currentNode.position);
            System.out.println("Description: " + currentNode.description);
            System.out.println(""); //gives a blank line between nodes
            currentNode = currentNode.nextNode;
        } while (currentNode != null); //We don't need to know ahead of time how many
        //nodes there are.
    }
    //append a new node to the end of the list and adjust pointers

    public static void append(int pos, String descr) {
        PipelineNode newNode = new PipelineNode(pos, descr, null);
        if (headNode == null) //There are no nodes yet so the node we
        {
//“append” will be both the head and the tail
            headNode = newNode;
        } else {
            tailNode.nextNode = newNode; //update the old tailNode
        }
        tailNode = newNode; //specify a new tailNode
    }
    private static PipelineNode headNode = null;
    private static PipelineNode tailNode = null;
}
