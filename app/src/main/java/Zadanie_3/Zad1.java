package Zadanie_3;

import java.awt.EventQueue;

public class Zad1 {
    
    public static void main(String[] args){
        int numberOfCircles = 10;
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Frame(numberOfCircles);
            }
        });
    }
}
//Jeśli piłka a zderzy się z drugą (b)
//To równamy prędkość a z b 
//Jeśli b zacznie przyspieszać