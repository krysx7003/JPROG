package Zadanie_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame extends JFrame {

    JButton butD = new JButton("DODAJ");
    JButton butU = new JButton("USUN");
    JButton butE = new JButton("EDYTUJ");
    JTextField text = new JTextField();
    DefaultListModel<Integer> dataModel = new DefaultListModel<>();
    JList<Integer> intJList =new JList<>(dataModel);
    JScrollPane scrollPane;
    Panel panel = new Panel();
    //size of int[]
    static int size = 0;
    //Adds a new int to scroll pane
    public void addToList(int newInt){
        //Add new number to scroll pane
        dataModel.add(size,newInt);        
        intJList.setModel(dataModel);
        //Redraw scroll pane
        scrollPane.repaint();
        size++;
    }
    public void changeList(int idToChange,int intToChange){
        //Change selected number to new one
        dataModel.set(idToChange,intToChange);
        intJList.setModel(dataModel);
        //Redraw scroll pane
        scrollPane.repaint();
    }
    public void remFromList(int idToRem){
        //Remove selected number from the list
        dataModel.remove(idToRem);
        //Remove color coresponding to removed value
        panel.removeColorAt(idToRem);
        size--;
        intJList.setModel(dataModel);
        //Redraw scroll pane
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
        JTextField outText = new JTextField();
        Font font = new Font("NazwaCzcionki", Font.BOLD, 12);
        //Add action listener to button "Dodaj"
        butD.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Gets a new int from text field
                    int newInt = Integer.parseInt(text.getText());
                    addToList(newInt);
                    //Repaint graph
                    putDiagram();
                    //Clear error message from output text
                    outText.setText("");
                } catch (Exception x) {
                    if(text.getText().equals(null)){
                        //Display error message in bold red letters
                        outText.setText("Podana wartosc nie jest integerem");
                        outText.setFont(font);
                        outText.setForeground(Color.RED);
                    }else{
                        //Display error message in bold red letters
                        outText.setText("Pole tekstowe jest puste, nie podano wartosci");
                        outText.setFont(font);
                        outText.setForeground(Color.RED);
                    }
                    
                }
                
            }

        });
        //Add action listener to button "Edytuj"
        butE.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(intJList.isSelectionEmpty()==false){
                    try {
                        //Gets a new int from text field
                        int intToChange = Integer.parseInt(text.getText()); 
                        //Gets index of selected number
                        int idToChange = intJList.getSelectedIndex();
                        changeList(idToChange, intToChange);
                        //Repaint graph
                        putDiagram();
                        //Clear error message from output text
                        outText.setText("");
                    } catch (Exception x) {
                        if(text.getText().equals(null)){
                            //Display error message in bold red letters
                            outText.setText("Podana wartosc nie jest integerem");
                            outText.setFont(font);
                            outText.setForeground(Color.RED);
                        }else{
                            //Display error message in bold red letters
                            outText.setText("Pole tekstowe jest puste, nie podano wartosci");
                            outText.setFont(font);
                            outText.setForeground(Color.RED);
                        }
                    }
                    
                }else{
                    //Display error message in bold red letters
                    outText.setText("Nie zaznaczono elemetu w tablicy");
                    outText.setFont(font);
                    outText.setForeground(Color.RED);
                }
            }

        });
        //Add action listener to button "Usun"
        butU.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(intJList.isSelectionEmpty()==false){
                    //Gets index of selected number
                    int idToRem = intJList.getSelectedIndex();
                    remFromList(idToRem);
                    //Repaint graph
                    putDiagram();
                    //Clear error message from output text
                    outText.setText("");
                }else{
                    //Display error message in bold red letters
                    outText.setText("Nie zaznaczono elemetu w tablicy");
                    outText.setFont(font);
                    outText.setForeground(Color.RED);
                }
            }

        });
        //Create new ListCellRenederer
        ListCellRenderer<? super Integer> customRenderer = new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                //If element is selected its background turns light gray
                if(isSelected){
                    renderer.setBackground(Color.LIGHT_GRAY);
                //Else its background is set to coresponding color from the graph
                }else{
                    renderer.setBackground(panel.getColorAt(index));
                }  
                
                return renderer;
            }
        };
        //Add custom renderer to intJList
        intJList.setCellRenderer(customRenderer);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(800,800);
        setLocation(200,200);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
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
        //Put output text in to frame
        c.gridx = 0;
        c.gridy = 1;
        outText.setEditable(false);
        add(outText,c);
        setVisible(true);
    }

}
