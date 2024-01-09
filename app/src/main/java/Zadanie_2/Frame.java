package Zadanie_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;

public class Frame extends JFrame {
    Panel panel = new Panel();
    JTextField[] allFields = new JTextField[10];
    JCheckBox[] allCheckBoxs = new JCheckBox[10];
    JPanel checkBoxPanel = new JPanel();
    JPanel textPanel = new JPanel();
    int[][] tabelOfValues = new int[2][10];
    
    public void redrawGraph(){

            
    }
    public Frame(){
        super("Zadanie 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(800,800);
        setLocation(200,200);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        //Create panel of text panels
        textPanel.setLayout(new GridLayout(0,1));
        //Create panel of check boxes
        checkBoxPanel.setLayout(new GridLayout(0,1));
        for(int i=0;i<10;i++){
            c.fill = GridBagConstraints.NONE;
            final int index = i;
            //Fill tabelOfValues with 0
            tabelOfValues[0][i] = 0;
            tabelOfValues[1][i] = 0;
            //Create new text field 4 columns wide
            allFields[i] = new JTextField(4);
            textPanel.add(allFields[i]);
            //Create new check box
            allCheckBoxs[i] = new JCheckBox();
            //Add a ItemListener to check box 
            allCheckBoxs[i].addItemListener(new ItemListener() {    
                public void itemStateChanged(ItemEvent e) {
                    //If check box was just selected  
                    if(allCheckBoxs[index].isSelected()){
                            //Set values of tabelOfValues to reflect current state
                            tabelOfValues[0][index] = 1;
                            tabelOfValues[1][index] = Integer.parseInt(allFields[index].getText());
                            //Redraw graph
                            redrawGraph();
                    //If check box was unselected
                        }else{
                            //Set "boolean" to false
                            tabelOfValues[0][index] = 0;
                        }     
                      
                }    
             });
            checkBoxPanel.add(allCheckBoxs[i]);
            
            
        }
        //Give tabelOfValues to Panel 
        panel.setList(tabelOfValues);
        //Put graph in frame
        add(panel,c);
        c.gridx = 2;
        //Put panel of 10 text panels in frame
        add(textPanel,c);
        c.gridx = 1;
        //Put panel of 10 check boxes
        add(checkBoxPanel,c);
        setVisible(true);
    }
    
    
    
}
