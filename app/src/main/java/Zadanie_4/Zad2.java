package Zadanie_4;

import java.awt.EventQueue;

public class Zad2 {
    public static void main(String[] args){

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Frame();
            }
        });
    }
}
