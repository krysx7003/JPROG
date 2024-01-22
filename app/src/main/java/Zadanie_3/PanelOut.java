package Zadanie_3;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class PanelOut extends JPanel {
    ArrayList<Circle> circles;
    ArrayList<Thread> threads = new ArrayList<>();
    PanelOut(int numberOfCircles,ArrayList<Circle> circles) {
        setPreferredSize(new Dimension(420, 400));
        this.circles = circles;
        for (Circle circle : circles) {
            Thread thread = new Thread(()->{
                while(true){
                    circle.move();
                    repaint();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threads.add(thread);
            thread.start();
        }
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawOval(10, 10, 380, 380);
        for (Circle circle : circles) {
            g.setColor(circle.getColor());
            //g.drawRect(circle.getX(), circle.getY(), 20, 20);
            g.fillOval(circle.getX(), circle.getY(), 20, 20);
        }
    }

}
