package com.tiny.game.model;


import com.tiny.game.view.Gui;

import java.awt.*;

public class GameOject {
    private static final int SIZE = 25 ;
    protected int index = 0;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;
    protected int x;
    protected int y;
    protected Image img;
    protected int orient;
    protected Image[][] arrImg;
    private int countMove;
    protected Rectangle rectangle;
    public GameOject(int x, int y) {
        this.x = x;
        this.y = y;
        rectangle =new Rectangle();
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(img, x, y, null);
    }

    protected Image getImage() {
        if (countMove % 10 == 0) {
            index++;
            if (countMove >= 1000000) {
                countMove = 0;
            }
        }
        if (index >= arrImg[orient].length) {
            index = 0;
        }
        return arrImg[orient][index];
    }



    public Rectangle getRectangle() {
        return rectangle;
    }

    public int getOrientation() {
        return orient;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
