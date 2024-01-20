package ballbounceassignment;

import java.awt.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author john
 */
public class Ball {

    int size = 20;
    //declare the size and the x、y coordinates of the ball
    int xCoordinate, yCoordinate, xDirection = 1, yDirection = 1;
    
    public Ball(){
        //random position the ball in the range of (1, 1) to (200, 200)
        xCoordinate = (int)(Math.random() * 200) + 1;
        yCoordinate = (int)(Math.random() * 200) + 1;
    }
    
    public void motion(double xDirection, double yDirection){
        //make the ball move right upward initially
        xCoordinate+=xDirection;
        yCoordinate-=yDirection;

    }
    
    public int getX() {
        return xCoordinate;
    }

    public int getY() {
        return yCoordinate;
    }
    
    public int getXD() {
        return xDirection;
    }

    public int getYD() {
        return yDirection;
    }
    
    public int getSize() {
        return size;
    }
}
