/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridworld;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author kell-gigabyte
 */
public class ChameleonCritter extends Critter {
    
    public ChameleonCritter(){
        this.c = Color.WHITE;
    }
    
    Color c;

    @Override
    public void processActors(ArrayList<Actor> actors) {
        if(!actors.isEmpty()){
       Actor a = actors.get((int)(Math.random() * actors.size())); // get a random actor
       this.c = a.getColor();
        }else{
            Color darker = this.c.darker();
            this.c = darker;
        }
        System.out.println(this.c.toString());
    }

    @Override
    public void makeMove(Location loc) {
        Location l = this.getLocation();
        int i = l.getDirectionToward(loc);
        this.setDirection(i);
        this.moveTo(loc);
        this.setColor(this.c);
    }
}
