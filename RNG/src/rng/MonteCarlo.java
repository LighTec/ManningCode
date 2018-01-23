/*
 * Created By Kell Larson for the Computer Science AP program during school year 2016/2017. Please ask before copying code.
 */
package rng;

import java.util.Random;

/**
 *
 * @author Kell
 */
public class MonteCarlo {

    private Random rndm = new Random();
    public double k;
    public double h;
    public double radius;

    public MonteCarlo(double h, double k, double r) {
        this.h = h;
        this.radius = r;
        this.k = k;
        //System.out.println("circle center x = " + this.h + " circle center y = " + this.k + " radius = " + this.radius);
    }

    public double nextRainDrop_x() {
        double d = (this.h * 2) * rndm.nextDouble();
        //System.out.println("double x = " + d);
        return d;
    }

    public double nextRainDrop_y() {
        double d = (this.k * 2) * rndm.nextDouble();
        //System.out.println("double y = " + d);
        return d;
    }

    public boolean insideCircle(double x, double y) {
        double radiusSq = Math.pow(this.radius, 2);
        double xhSq = Math.pow((x - this.h), 2);
        double ykSq = Math.pow((y - this.k), 2);

        if (ykSq + xhSq <= radiusSq) {
            return true;
        } else {
            return false;
        }
    }
}
