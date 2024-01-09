package Zadanie_1;


import java.awt.EventQueue;

public class Zad6 {

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
    //DPODAJ
    //dodaje liczbe z pola tekstowego
    //wyliczanie fragmentu wykresu
    //Suma ni a nastepnie ni/suma *360
    //rysowanie
    //fillArc(x,y,width,height,int startArc,int Arc)
    //Arc>0 counterclockwise
    //Arc<0 clockwise
    //uważać na zaokrąglenia
    //wrazie czego można dodać puste pole do największego kawałka


}
