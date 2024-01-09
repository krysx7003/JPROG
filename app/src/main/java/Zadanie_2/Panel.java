package Zadanie_2;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

public class Panel extends JPanel {
    static ArrayList<Color> colorWheel = new ArrayList<>();
    Integer[] list;
    public Panel() {
        setPreferredSize(new Dimension(400, 200));
        for(int i=0;i<10;i++){
            colorWheel.add(newColor());
        }
    }
    public Color newColor(){
        Random rand = new Random();
        //Zmiana koloru na losowy
        float red = rand.nextFloat();
        float green = rand.nextFloat();
        float blue = rand.nextFloat();
        return new Color(red,green,blue);
    }
    public void setList(Integer[] listToSet){
        this.list = listToSet;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i=0;i<10;i++){
            g.setColor(colorWheel.get(i));
            g.fillRect(10*i*2, 10, 10, 200);
        }
        
    }


}
