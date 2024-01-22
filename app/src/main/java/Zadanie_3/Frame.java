package Zadanie_3;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    
    Frame(int  numberOfCircles){
        super("Zadanie 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        setSize(800,800);
        setLocation(200,200);
        setVisible(true);
        PanelIn panelIn = new PanelIn(numberOfCircles);
        PanelOut panelout = new PanelOut(numberOfCircles,panelIn.getCircles());
        JScrollPane scrollPane = new JScrollPane(panelIn);
        scrollPane.setPreferredSize(new Dimension(250,300));
        c.gridx = 0;
        add(panelout,c);
        c.gridx = 1;
        add(scrollPane,c);
    }

}
