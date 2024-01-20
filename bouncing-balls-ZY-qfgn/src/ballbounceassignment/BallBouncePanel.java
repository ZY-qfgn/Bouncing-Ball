/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballbounceassignment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 *
 * @author john
 */
public class BallBouncePanel extends javax.swing.JPanel {
    //variable declaration
    //the moving speed of the ball
    private Timer t1 = new Timer (10, new TimerListener());
    //create a ball
    private ArrayList<Ball> b = new ArrayList<Ball>();
    private Ball ball = new Ball();
    //initial background is golf field
    private String background = "golf field.jpg";
    private Graphics g;     
    //initial color of the ball is black
    private int red = 0, green = 0, blue = 0;

    /**
     * Creates new form BallBouncePanel
     */
    public BallBouncePanel() {
        initComponents();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //set background
        Image img = Toolkit.getDefaultToolkit().getImage(background);
        g.drawImage(img, 0, 0, this);      
        //set color
        Color c = new Color(red, green, blue);    
        g.setColor(c);           
        //draw circle
        for (int i=0; i<b.size(); i++){
            ball = b.get(i);
            g.fillOval(ball.getX(), ball.getY(), ball.getSize(), ball.getSize());     
            repaint();
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
   private class TimerListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            //make the ball move
            for (int i=0; i<b.size(); i++){
                ball = b.get(i);
                ball.motion(ball.xDirection, ball.yDirection);
                //make sure the ball do not sink into the edge, so minus the size of the ball
                //if hit the edge, change direction
                if (ball.getY()<=0 || ball.getY()>=getHeight()-20){
                    ball.yDirection *= -1;
                }
                if (ball.getX()<=0 || ball.getX()>=getWidth()-20){
                    ball.xDirection *= -1;
                }
                repaint();
            }
        }
    }
   
   public void anim(){
       //start the timer
        t1.start();
   }

    public void animStop(){
        //stop the timer
       t1.stop();    
   }
    
    public void setDirection(int speed) {
        //make sure when changing speed, the ball will not bounce back the "air"
        //in case the moving orientation is negative, but the speed is always positive
        for (int i=0; i<b.size(); i++){
            ball = b.get(i);
            if (ball.xDirection<0){
                ball.xDirection = -speed;
            }
            if (ball.yDirection<0){
                ball.yDirection = -speed;
            }
            else{
                //enable to change speed
                ball.xDirection = speed;
                ball.yDirection = speed;
            }
        }
    }
    
    public void setBackground(String text) {
        //enable to change background
        background = text+".jpg";
    }
    
    public void setRedColor(int r) {
        //set red color
        red = r;
    }
    
    public void setGreenColor(int g) {
        //set green color
        green = g;
    }
    
    public void setBlueColor(int b) {
        //set blue color
        blue = b;
    }
    
    public void addBall(){
        Ball bNew = new Ball();
        b.add(bNew);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
