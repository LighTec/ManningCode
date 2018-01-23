/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptiontester;

/**
 *
 * @author kell-gigabyte
 */
public class GeorgeTooBallzDeep extends RuntimeException{
    public GeorgeTooBallzDeep(){
        
    }
    public GeorgeTooBallzDeep(String s){
        super(s);
    }
}
