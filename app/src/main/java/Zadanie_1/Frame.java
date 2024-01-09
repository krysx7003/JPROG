package Zadanie_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame extends JFrame implements ActionListener{

    JButton butD = new JButton("DODAJ");
    JButton butU = new JButton("USUN");
    JButton butE = new JButton("EDYTUJ");
    JTextField text = new JTextField();
    DefaultListModel<Integer> dataModel = new DefaultListModel<>();
    JList<Integer> intJList =new JList<>(dataModel);
    JScrollPane scrollPane;
    int idToChange;
    Panel panel = new Panel();
    //size of int[]
    static int size = 0;
    //Adds a new int to scroll pane
    public void addToList(int newInt){
        //adds new number to scroll pane
        dataModel.add(size,newInt);
        size++;
        intJList =new JList<>(dataModel);
        scrollPane =new JScrollPane(intJList);
        //Redraws scroll pane
        scrollPane.repaint();
    }
    public void changeList(int idToChange,int intToChange){
        //Changes selected number to new one
        dataModel.set(idToChange,intToChange);
        intJList =new JList<>(dataModel);
        scrollPane =new JScrollPane(intJList);
        //Redraws scroll pane
        scrollPane.repaint();
    }
    public void remFromList(int idToRem){
        //Removes selected number from the list
        dataModel.remove(idToRem);
        size--;
        intJList =new JList<>(dataModel);
        scrollPane =new JScrollPane(intJList);
        //Redraws scroll pane
        scrollPane.repaint();

    }
    public void putDiagram(){
        //Updates diagram to reflect new list
        Integer[] lista = new Integer[size];
        dataModel.copyInto(lista);
        panel.setList(lista,size);
        //Redraws diagram
        panel.repaint();
        
    }
    public Frame() {
        super("Zadanie 1");
        butD.addActionListener(this);
        butE.addActionListener(this);
        butU.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(800,800);
        setLocation(200,200);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        //tmp number input
        /*
         for(;size<10;){
            addToList(size*3);
            //dataModel.add(size,size*3);
        }
        */ 
        //Put diagram in to frame
        add(panel);
        //Put scrollable pane in to frame
        scrollPane =new JScrollPane(intJList);
        intJList.setFocusable(false);
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 3;
        c.fill = 1;
        add(scrollPane,c);
        ///Put text field in to frame 
        c.gridx = 1;
        c.gridy = 1;
        add(text,c);
        //Put button "Dodaj" in to frame
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 2;
        add(butD,c);
        //Put button "Usun" in to frame
        c.gridx = 2;
        c.gridy = 2;
        add(butU,c);
        //Put button "Edytuj" in to frame
        c.gridx = 3;
        c.gridy = 2;
        add(butE,c);
        setVisible(true);
    }


    @Override
 		public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
 			if(source == butD){
                //Gets a new int from text field
                int newInt = Integer.parseInt(text.getText());
                addToList(newInt);
                putDiagram();
            } else if(source == butU){
                if(intJList.isSelectionEmpty()==false){
                    //Gets index of selected number
                    int idToRem = intJList.getSelectedIndex();
                    remFromList(idToRem);
                    putDiagram();
                }
            } else if(source == butE){
                if(intJList.isSelectionEmpty()==false){
                    //Gets index of selected number
                    int idToChange = intJList.getSelectedIndex();
                    //Gets a new int from text field
                    int intToChange = Integer.parseInt(text.getText()); 
                    changeList(idToChange, intToChange);
                    putDiagram();
                }
            }
 		}
}
