
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thtnm
 */
public class Main {

    public static void main(String args[]) {
        Square square = new Square("square");
        Circle circle = new Circle("circle");
        Triangle triangle = new Triangle("triangle");
        EquilateralTriangle equilateralTriangle = new EquilateralTriangle("equilateralTriangle");
        
        Scanner kb = new Scanner(System.in);
        System.out.println("Square\nEnter length and height: ");
        int n = kb.nextInt();
        int m = kb.nextInt();
        
        System.out.println("Circle\nEnter radius: ");
        int r = kb.nextInt();
        
        System.out.println("Triangle\nEnter sides 1, 2, and 3: ");
        int one = kb.nextInt();
        int two = kb.nextInt();
        int three = kb.nextInt();
        
        System.out.println("Equilateral Triangle\nEnter side: ");
        int s = kb.nextInt();
        
        
        
        square.setDimensions(n, m);
        square.printDimensions();
        System.out.println("Area: " + square.getArea());
        
        circle.setDimensions(r);
        circle.printDimensions();
        System.out.println("Area: " + circle.getArea());
        
        triangle.setDimensions(one, two, three);
        triangle.printDimensions();
        System.out.println("Area: " + triangle.getArea());
        
        equilateralTriangle.setDimensions(s);
        equilateralTriangle.printDimensions();
        System.out.println("Area: " + equilateralTriangle.getArea());


    }

}
