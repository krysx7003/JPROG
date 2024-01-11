package Zadanie_3;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class Panel extends JPanel{
    static ArrayList<Color> colorWheel = new ArrayList<>();
    Panel(int  numberOfCircles){
        setPreferredSize(new Dimension(400, 400));
        for(int i=0;i<10;i++){
            colorWheel.add(newColor());
        }
    }
    public Color newColor(){
        Random rand = new Random();
        //Get new random Color
        float red = rand.nextFloat();
        float green = rand.nextFloat();
        float blue = rand.nextFloat();
        return new Color(red,green,blue);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawOval(0, 0, 380, 380);
    }
}
