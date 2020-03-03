/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thtnm
 */
public class EquilateralTriangle extends Triangle {
    
    int side = 0;

    public EquilateralTriangle(String name) {
        super(name);
    }
    
    void setDimensions(int side){
        this.side = side;
    }
    
    @Override
    public void printDimensions(){
        System.out.println("Equilateral Triangle Dimensions:\nSide: " + this.side);
    }
    
    public double getArea() {
        double s = (3 * this.side) / 2;
        return Math.sqrt(s * (s-this.side) * (s-this.side) * (s-this.side));
    }

}
