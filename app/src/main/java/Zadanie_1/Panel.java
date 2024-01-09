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
        //Zmiana koloru na losowy
        float red = rand.nextFloat();
        float green = rand.nextFloat();
        float blue = rand.nextFloat();
        return new Color(red,green,blue);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Kolo
        g.drawOval(10, 10, 380, 380);
        //Sumowanie tablicy
        int sum = 0;
        for(int i=0;i<size;i++){
            sum = sum+list[i];
        }
        //Rysowanie całości
        int startAngle = 0;
        int currAngle = 0;
        for(int i=0;i<size;i++){
            //Luki 
            //x,y,w,h luku == x,y,w,h kola
            //startAngle[i] = startAngle[i-1] + arcAngle[i-1]
            double Angle=0;
            g.setColor(colorWheel.get(i));
            Angle = ((double)list[i]/sum)*360;
            currAngle = (int)Angle;
            g.fillArc(10,10,380,380,startAngle,currAngle);
            startAngle = startAngle+currAngle;
        }
        colorWheel.add(newColor());
        g.setColor(colorWheel.get(size));
        currAngle = 360 - startAngle;
        g.fillArc(10,10,380,380,startAngle,currAngle);

        
        
    }
    public void setList(Integer[] list,int size){
        this.list = list;
        this.size = size;
    }
}
