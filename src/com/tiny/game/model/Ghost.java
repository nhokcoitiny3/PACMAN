package com.tiny.game.model;

import com.tiny.game.manger.GameManager;
import com.tiny.game.manger.Images;
import com.tiny.game.view.Gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Admin on 4/15/2017.
 */
public class Ghost extends GameOject {

    public static final int SIZE = 25;
    public static final int LEFT = 3;
    public static final int RIGHT = 1;
    public static final int UP = 0;
    public static final int DOWN = 2;

    public int index = 0;
    private int countMove;
    private Image[][] arrImg;
    private int speed;
    private Random random;

    public Ghost(int x, int y, int orient, Image[][] arrImg) {
        super(x, y);
        this.orient = orient;
        speed=2;
        rectangle = new Rectangle(x, y, SIZE, SIZE);
        this.arrImg = arrImg;
        img = getImage();
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(img, x, y, SIZE, SIZE, null);
    }
    public void drawIghost(Graphics2D graphics2D) {

        graphics2D.drawImage(Images.IsGhost,x,y,SIZE,SIZE,null);
    }

    protected Image getImage() {
        if (countMove % 10 == 0) {
            index++;
            if (countMove >= 100000) {
                countMove = 0;
            }
        }
        if (index >= arrImg[orient].length) {
            index = 0;
        }
        return arrImg[orient][index];
    }

    public void move() {

        countMove++;
        img = getImage();
        if (x == Gui.WIDTH_FRAME - 195) {
            x = 0;
        }
        if (x == -SIZE) {
            x = Gui.WIDTH_FRAME - 195;
        }

        switch (orient) {
            case LEFT:
                x -= speed;
                rectangle.setLocation(x - 1, y);
                break;
            case RIGHT:
                x += speed;
                rectangle.setLocation(x + 1, y);
                break;
            case UP:
                y -= speed;
                rectangle.setLocation(x, y - 1);
                break;
            case DOWN:
                y += speed;
                rectangle.setLocation(x, y + 1);
                break;
        }
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setOrentation(int orientation) {
        if (this.orient != orientation) {
            this.orient = orientation;
            switch (orientation) {
                case LEFT:
                    rectangle.setLocation(x - 1, y);
                    break;
                case UP:
                    rectangle.setLocation(x, y - 1);
                    break;
                case RIGHT:
                    rectangle.setLocation(x + 1, y);
                    break;
                case DOWN:
                    rectangle.setLocation(x, y + 1);
                    break;
                default:
                    break;
            }
        }
    }


    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
