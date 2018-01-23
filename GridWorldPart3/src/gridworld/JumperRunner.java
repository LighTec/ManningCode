/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridworld;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import java.awt.Color;

/**
 *
 * @author kell-gigabyte
 */
public class JumperRunner {

    /**
     * This class runs a world that contains box bugs. This class is not tested
     * on the AP CS A and AB exams.
     *
     * @param args
     */
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        
        Jumper a = new Jumper(Color.BLUE);
        Jumper b = new Jumper(Color.GREEN);
        world.add(a);
        world.add(b);
        
        world.add(new Rock());
        world.add(new Rock());
        world.add(new Rock());
        world.add(new Rock());
        world.add(new Rock());
        world.add(new Rock());
        world.add(new Rock());
        world.add(new Rock());
        world.add(new Rock());
        
        world.show();
       
    }
}