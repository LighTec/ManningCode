/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpj40_multikeysort;

import java.util.Scanner;

/**
 *
 * @author kell-gigabyte
 */
public class NameAge {
    
    private String name;
    private int age;
    
    
    public NameAge(String s){       //Must be formatted as name, then a space, then age.
        Scanner sc = new Scanner(s);
        this.name = sc.next();
        this.age = Integer.parseInt(sc.next());
        sc.close();
        ///System.out.println(this.age + " asfg " + this.name);
    }
    
    public NameAge(String name, int age){
        this.name = name;
        this.age = age;
    }
    
    public int getAge(){
        return this.age;
    }
    
    public String getName(){
        return this.name;
    }
    
    @Override
    public String toString(){
        String s = this.name + ", " + this.age;
        return s;
    }
    
}
