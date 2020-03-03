/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thtnm
 */
public class Square extends Shape {
    
    int length = 0;
    int height = 0;

    public Square(String name) {
        super(name);
    }
    
    void setDimensions(int length, int height){
        this.length = length;
        this.height = height;
    }
    
    @Override
    public void printDimensions(){
        System.out.println("Square Dimensions:\nLength: " + this.length + "\nHeight: " + this.height);
    }
    
    @Override
    public double getArea() {
        return this.length * this.height;
    }

}
