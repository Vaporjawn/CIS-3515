/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thtnm
 */
public class Triangle extends Shape {
    
    int side1 = 0;
    int side2 = 0;
    int side3 = 0;
    
    

    public Triangle(String name) {
        super(name);
    }
    
    void setDimensions(int side1, int side2, int side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        
    }
    
    @Override
    public void printDimensions(){
        System.out.println("Triangle Dimensions:\nSide1: " + this.side1 + "\nSide2: " + this.side2 + "\nSide3: " + this.side3);
    }
    
    @Override
    public double getArea() {
        double s = (this.side1 + this.side2 + this.side3) / 2;
        return Math.sqrt(s * (s-this.side1) * (s-this.side2) * (s-this.side3));
    }

}
