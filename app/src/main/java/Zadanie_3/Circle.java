package Zadanie_3;

import java.awt.Color;

public class Circle {
    private int x;
    private int y;
    private Color color;
    private int speed;
    int radius = 190;
    int xZero = 190;
    int yZero = 190;
    double t = 0;

    public Circle(int x, int y, Color color, int speed,double t) {
        this.x = x;
        this.y = y;
        this.t = t;
        this.color = color;
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int newSpeed){
        this.speed = newSpeed;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void move() {
        t = t+(double)speed/100;
        Double newY = 190*Math.cos(t);
        Double newX = 190*Math.sin(t);
        y = (int)Math.round(newY)+190;
        x = (int)Math.round(newX)+190;

    }
}
