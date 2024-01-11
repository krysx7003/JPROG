package Zadanie_3;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    Frame(int  numberOfCircles){
        super("Zadanie 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(800,800);
        setLocation(200,200);
        setVisible(true);
        Panel panel = new Panel(numberOfCircles);
        add(panel);
    }
}
