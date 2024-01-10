package Zadanie_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Frame extends JFrame  {
    Panel panel = new Panel();
    JTextField[] allFields = new JTextField[10];
    JTextField[] allLabels = new JTextField[10];
    JCheckBox[] allCheckBoxs = new JCheckBox[10];
    JPanel checkBoxPanel = new JPanel();
    JPanel textPanel = new JPanel();
    JPanel labelPanel = new JPanel();
    int[][] tabelOfValues = new int[2][10];
    
    public Frame(){
        super("Zadanie 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(600,400);
        setLocation(200,200);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JTextField outField = new JTextField();
        //Create panel of text panels
        textPanel.setLayout(new GridLayout(0,1));
        //Create panel of check boxes
        checkBoxPanel.setLayout(new GridLayout(0,1));
        //Create panel of labels from 1 to 10
        labelPanel.setLayout(new GridLayout(0,1));
        //Create bold font
        Font font = new Font("Bold", Font.BOLD, 12);
        //Get colors from panel
        ArrayList<Color> colorWheel = panel.getColors();
        for(int i=0;i<10;i++){
            final int index = i;
            //Fill tabelOfValues with 0
            tabelOfValues[0][i] = 0;
            tabelOfValues[1][i] = 0;
            //Add 10 text fields to textPanel
            //Create new text field 4 columns wide
            allFields[i] = new JTextField(4);
            //Set background of text field to coolor from graph
            allFields[i].setBackground(colorWheel.get(i));
            //Add a ActionListener to each check box 
            allFields[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Redraw graph
                    panel.setList(tabelOfValues);
                    panel.repaint();
                    //Display succes message in bold green letters
                    outField.setText("Wykres zostal przerysowany");
                    outField.setFont(font);
                    outField.setForeground(Color.GREEN);
                }
            });
            textPanel.add(allFields[i]);
            //Add 10 check boxes to checkBoxPanel
            //Create new check box
            allCheckBoxs[i] = new JCheckBox();
            //Add a ItemListener to each check box 
            allCheckBoxs[i].addItemListener(new ItemListener() {    
                public void itemStateChanged(ItemEvent e) {
                    //If check box was just selected  
                    if(allCheckBoxs[index].isSelected()){
                            //Set values of tabelOfValues to reflect current state
                            try{
                                tabelOfValues[1][index] = Integer.parseInt(allFields[index].getText());
                                tabelOfValues[0][index] = 1;
                                outField.setText("");
                            }catch(NumberFormatException x){   
                                //Display error message in bold red letters     
                                outField.setText("Pole "+index+" nie zawiera liczby typu int");
                                outField.setFont(font);
                                outField.setForeground(Color.RED);
                            }    
                    //If check box was unselected
                        }else{
                            //Set "boolean" to false
                            tabelOfValues[0][index] = 0;
                        }     
                }    
            });
            //Add key KeyListener to each checkbox
            allCheckBoxs[i].addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        //Display succes message in bold green letters
                        outField.setText("Wykres zostal przerysowany");
                        panel.setList(tabelOfValues);
                        panel.repaint();
                        outField.setFont(font);
                        outField.setForeground(Color.GREEN);
                    }
                }
            });
            checkBoxPanel.add(allCheckBoxs[i]);
            //Add labels from 1 to 10 to labelPanel
            allLabels[i] = new JTextField(2);
            allLabels[i].setText("   "+(i+1)+".");
            allLabels[i].setEditable(false);
            labelPanel.add(allLabels[i]);   
        }
        //Give tabelOfValues to Panel 
        panel.setList(tabelOfValues);
        //Put graph in to frame
        add(panel,c);
        c.gridx = 3;
        //Put panel of 10 text panels in to frame
        add(textPanel,c);
        c.gridx = 2;
        //Put panel of 10 check boxes in to frame
        add(checkBoxPanel,c);
        //Put panel of labels from 1 to 10 in frame
        c.gridx = 1;
        add(labelPanel,c);
        //Put output fieldin in to frame
        c.gridx = 0;
        c.gridy = 1;
        c.fill  = 1;
        outField.setEditable(false);
        add(outField,c);
        //Add action listener to "Redraw" button
        JButton redrawButton = new JButton("Redraw");
        redrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Display succes message in bold green letters
                outField.setText("Wykres zostal przerysowany");
                panel.setList(tabelOfValues);
                panel.repaint();
                outField.setFont(font);
                outField.setForeground(Color.GREEN);
            }
        });
        //Put button "Redraw" in to frame
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 3;
        c.fill  = 3;
        add(redrawButton,c);
        setVisible(true);
    }

}
