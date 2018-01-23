/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridworld;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import java.awt.Color;

/**
 *
 * @author kell-gigabyte
 */
public class CritterRunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();

        //Critter c = new Critter();
        //ChameleonCritter cc = new ChameleonCritter();
        //Jumper b = new Jumper(Color.GREEN);
        //ChameleonKid ck = new ChameleonKid();
        //world.add(ck);
        //RockHound rh = new RockHound();
        //world.add(rh);
        //world.add(cc);
        //BlusterCritter bc = new BlusterCritter(1);
        //world.add(bc);
        QuickCrab qc = new QuickCrab();
        world.add(qc);

        KingCrab kfc = new KingCrab();
        world.add(kfc);

        Bug b = new Bug();
        Bug c = new Bug();
        Bug d = new Bug();
        world.add(c);
        world.add(b);
        world.add(d);

        world.add(new Rock(Color.BLACK));
        world.add(new Rock(Color.CYAN));
        world.add(new Rock(Color.ORANGE));
        world.add(new Rock(Color.RED));
        world.add(new Rock(Color.GREEN));

        world.show();
    }

}
