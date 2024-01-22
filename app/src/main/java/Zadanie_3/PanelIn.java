package Zadanie_3;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class PanelIn extends JPanel{
    JSlider[] allSliders;
    ArrayList<Color> colorWheel = new ArrayList<>();
    ArrayList<Integer> speedList = new ArrayList<>();
    ArrayList<Circle> circles = new ArrayList<>();
    int numberOfCircles;
    int bound = 30;
    public int randomSpeed(){
        Random rand = new Random();
        int speed = rand.nextInt(bound);
        return speed;
    }
    public ArrayList<Circle> getCircles(){
        return circles;
    }
    public Color newColor(){
        Random rand = new Random();
        //Get new random Color
        float red = rand.nextFloat();
        float green = rand.nextFloat();
        float blue = rand.nextFloat();
        return new Color(red,green,blue);
    }
    PanelIn(int numberOfCircles){
        this.numberOfCircles = numberOfCircles;
        allSliders = new JSlider[numberOfCircles];
        JTextField[] allTextFields = new JTextField[numberOfCircles]; 
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        setPreferredSize(new Dimension(200, 300));
        for(int i=0;i<numberOfCircles;i++){
            colorWheel.add(newColor());
            int speed =randomSpeed();
            speedList.add(speed);
            circles.add(new Circle(190, 0, colorWheel.get(i), speedList.get(i),t)); 
            final int index = i;
            c.gridy = i;
            c.gridx = 1;
            allSliders[i]= new JSlider(0,bound, speed);
            allSliders[i].addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    int speed = allSliders[index].getValue();
                    allTextFields[index].setText(speed+"");
                    circles.get(index).setSpeed(speed);
                }
                
            });
            add(allSliders[i],c);
            allTextFields[i] = new JTextField(2);
            allTextFields[i].setText(speed+"");
            allTextFields[i].setEditable(false);
            allTextFields[i].setBackground(colorWheel.get(i));
            c.gridx = 0;
            add(allTextFields[i],c);
        }

    }
}
