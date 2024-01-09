package Zadanie_2;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;

public class Frame extends JFrame {
    Panel panel = new Panel();
    JTextField[] allFields = new JTextField[10];
    JCheckBox[] allCheckBoxs = new JCheckBox[10];
    JPanel checkBoxPanel = new JPanel();
    JPanel textPanel = new JPanel();
    public Frame(){
        super("Zadanie 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(800,800);
        setLocation(200,200);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 0;
        c.weighty = 0;
        c.weightx = 0;
        add(panel,c);
        textPanel.setLayout(new GridLayout(0,1));
        checkBoxPanel.setLayout(new GridLayout(0,1));
        for(int i=0;i<10;i++){
            
            
            c.fill = GridBagConstraints.NONE;
            
            allFields[i] = new JTextField(4);
            textPanel.add(allFields[i]);
            
            
            allCheckBoxs[i] = new JCheckBox();
            checkBoxPanel.add(allCheckBoxs[i]);
            
            
        }
        c.gridx = 2;
        
        add(textPanel,c);
        c.gridx = 1;
        add(checkBoxPanel,c);
        setVisible(true);
    }

    
}
