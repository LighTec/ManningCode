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
public class PipelineNode {

    public PipelineNode(int pos, String descr, PipelineNode ptr) //Constructor
    {
        position = pos;
        description = descr;
        nextNode = ptr;
    }
    public int position;
    public String description;
    public PipelineNode nextNode;
}
