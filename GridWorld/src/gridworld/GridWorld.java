/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridworld;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import java.awt.Color;

/**
 *
 * @author kell-gigabyte
 */
public class GridWorld {

    /**
     * This class runs a world that contains box bugs. This class is not tested
     * on the AP CS A and AB exams.
     *
     * @param args
     */
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();

       // makeFlowers(world, 20);
        
       // MyTermite alice = new MyTermite();
       LangtonTermite alice = new LangtonTermite();
        alice.setColor(Color.CYAN);
       // MyTermite charlie = new MyTermite();

       LangtonTermite bob = new LangtonTermite();
        //MyTermite bob = new MyTermite();
        bob.setColor(Color.blue);
        
        LangtonTermite charlie = new LangtonTermite();
        /*
        int[] danceArr = {3, 1, 2, 5, 6, 7, 4, 11, 1, 4, 5, 7, 4, 8, 1, 2, 5, 3, 6, 8, 4, 4, 5};
        DancingBug derek = new DancingBug(danceArr);
        derek.setColor(Color.GREEN);

        CircleBug alice = new CircleBug(3);
        SpiralBug john = new SpiralBug(4);
        ZBug zed = new ZBug(4);
        alice.setColor(Color.ORANGE);
        john.setColor(Color.BLUE);
        BoxBug bob = new BoxBug(5);
         */
        //world.add(charlie);
        //world.add(bob);
        world.add(alice);
        
        //world.add(new Location(7, 8), alice);
        //world.add(new Location(5, 5), bob);
        //world.add(new Location(4, 5), john);
        //world.add(new Location(6, 6), zed);
        //world.add(new Location(4, 4), derek);

        world.show();
    }

    public static void makeFlowers(ActorWorld world, int n) {
        for (int i = 0; i < n; i++) {
            world.add(new EternalFlower());
        }
    }
}
