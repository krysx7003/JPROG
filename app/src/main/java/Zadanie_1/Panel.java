package Zadanie_1;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

public class Panel extends JPanel {
    Integer[] list = new Integer[0];
    int size = 0;
    static ArrayList<Color> colorWheel = new ArrayList<>();
    public Panel() {
        setPreferredSize(new Dimension(400, 400));
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
        if(size!=0){
            //Sum every number in the array
            int sum = 0;
            for(int i=0;i<size;i++){
                sum = sum+list[i];
            }
            //Draw everything
            int startAngle = 0;
            int currAngle = 0;
            for(int i=0;i<size;i++){
                //Redraw previously drawn angles 
                double Angle=0;
                //Get Color from colorWheel
                g.setColor(colorWheel.get(i));
                //Angle is percentage of the wheel
                Angle = ((double)list[i]/sum)*360;
                currAngle = (int)Angle;
                //x,y,w,h angle == x,y,w,h circle
                g.fillArc(10,10,380,380,startAngle,currAngle);
                //When curren angle stop next one will start
                startAngle = startAngle+currAngle;
            }

            colorWheel.add(newColor());
            //Draw new Angle
            //Get Color from colorWheel
            g.setColor(colorWheel.get(size));
            //currAngle is set to leftover part of the wheel 
            currAngle = 360 - startAngle;
            g.fillArc(10,10,380,380,startAngle,currAngle);
        }
        //Draw circle
        g.drawOval(10, 10, 380, 380);
    }
    public void setList(Integer[] list,int size){
        //Set list of Integers and its size
        this.list = list;
        this.size = size;
    }
}
