package Zadanie_2;

import java.awt.EventQueue;

public class Zad7 {

    public static void main(String[] args){
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Frame();
            }
        });


    }
    //wysokość wykresu to największa zaznaczona liczba
    //przerysowanie po naciśnięciu ENTER albo
    //
}
