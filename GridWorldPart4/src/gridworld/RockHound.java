/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridworld;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author kell-gigabyte
 */
public class RockHound extends Critter {
    
    public RockHound(){
        this.setColor(Color.gray);
    }

    @Override
    public void processActors(ArrayList<Actor> actors) {
        for (Actor a : actors) {
            if (a instanceof Rock) {
                a.removeSelfFromGrid();
            }
        }
    }
}
