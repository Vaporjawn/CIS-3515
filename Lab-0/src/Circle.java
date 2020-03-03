
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thtnm
 */
public class Circle extends Shape{
    
    int radius = 0;
    
    public Circle(String name) {
        super(name);
    }
    
    void setDimensions(int radius){
        this.radius = radius;
    }
    
    @Override
    public void printDimensions(){
        System.out.println("Circle Dimensions:\nRadius: " + this.radius);
    }
    
    @Override
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }
    
}
