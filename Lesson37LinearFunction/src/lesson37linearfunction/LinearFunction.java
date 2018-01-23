/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson37linearfunction;

/**
 *
 * @author kell-gigabyte
 */
public class LinearFunction implements LinearFunctionMethods {
    
    private double slope;
    private double yIntercept;
    
    public LinearFunction(double slope, double yIntercept){
        this.slope = slope;
        this.yIntercept = yIntercept;
    }
    
    public double getSlope(){
    return this.slope;
}
    public double getYintercept(){
    return this.yIntercept;
}
    public double getRoot(){
        return this.yIntercept / this.slope;
    }
    public double getYvalue(double x){
        return (this.slope * x) + this.yIntercept;
    }
    
    public double getXvalue(double y){
        return (y - this.yIntercept) / this.slope;
    }
    
}
