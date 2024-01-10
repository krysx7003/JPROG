package Zadanie_2;

import java.awt.*;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

public class Panel extends JPanel {
    static ArrayList<Color> colorWheel = new ArrayList<>();
    int[][] list;
    public Panel() {
        setPreferredSize(new Dimension(400, 200));
        //After initialization get 10 random Colors 
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
    public ArrayList<Color> getColors(){
        //Return whole colorWheel
        return colorWheel;
    }
    public void setList(int[][] listToSet){
        //Set list of "booleans" and ints
        this.list = listToSet;
    }
    public boolean checkIfListEmpty(){
        //Go through whole array and check if there are numbers in it
        for(int i=0;i<10;i++){
            if(list[1][i]!=0){
                //If there are numbers return false
                return false;
            }
        }
        //If there aren't return true
        return true;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Draw simple guide line
        if(!checkIfListEmpty()){
            int newMax = 0;
            int ammountOfBoxes = 0;
            for(int i=0;i<10;i++){
                //Find highest number in array
                if(list[1][i]>newMax){
                    newMax = list[1][i];
                }
                //Count how many checked boxes there are
                ammountOfBoxes = ammountOfBoxes+list[0][i];
            }
            //Set width of each column
            int width = 360/ammountOfBoxes;
            int j = 0;
            for(int i=0;i<10;i++){
                //Setsone of the Colors in colorWheel
                g.setColor(colorWheel.get(i));
                //If box is checked draws rectangle
                if(list[0][i]==1){
                    //Calculate height of the column
                    double height =(double)list[1][i]/newMax;
                    height = height*200;
                    g.fillRect(width*j+20, 200-(int)height, width, (int)height);
                    j++;
                }    
            }
        }
        g.setColor(Color.BLACK);
        //Draw simple guide box
        g.drawRect(0, 0, 399, 199);
        
    }


}
