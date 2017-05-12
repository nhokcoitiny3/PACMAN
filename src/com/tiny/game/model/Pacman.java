package com.tiny.game.model;

import com.tiny.game.manger.Images;
import com.tiny.game.view.Gui;

import javax.swing.*;
import java.awt.*;


public class Pacman extends GameOject {
    public int index = 0;
    public static final int SIZE = 25;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;
    public boolean isDead;
    private int speed;
    private Image img;
    private int countMove;
    private Rectangle rectangle;

    protected int orient;
    protected Image[][] arrImg;


    public Pacman(int x, int y,int orient) {
        super(x, y);
        this.orient = orient;
        speed = 1;
        rectangle = new Rectangle(x, y, SIZE, SIZE);
        isDead=false;
        arrImg = new Image[][]{
                {
                        new ImageIcon(getClass().getResource("/res/drawable/Pacman/pacman_left_1.png")).getImage(),
                        new ImageIcon(getClass().getResource("/res/drawable/Pacman/pacman_left_2.png")).getImage(),
                        new ImageIcon(getClass().getResource("/res/drawable/Pacman/pacman_left_3.png")).getImage()
                },
                {
                new ImageIcon(getClass().getResource("/res/drawable/Pacman/pacman_right_1.png")).getImage(),
                new ImageIcon(getClass().getResource("/res/drawable/Pacman/pacman_right_2.png")).getImage(),
                new ImageIcon(getClass().getResource("/res/drawable/Pacman/pacman_right_3.png")).getImage()
        },
                {
                        new ImageIcon(getClass().getResource("/res/drawable/Pacman/pacman_top_1.png")).getImage(),
                        new ImageIcon(getClass().getResource("/res/drawable/Pacman/pacman_top_2.png")).getImage(),
                        new ImageIcon(getClass().getResource("/res/drawable/Pacman/pacman_top_3.png")).getImage()
                },
                {
                        new ImageIcon(getClass().getResource("/res/drawable/Pacman/pacman_down_1.png")).getImage(),
                        new ImageIcon(getClass().getResource("/res/drawable/Pacman/pacman_down_2.png")).getImage(),
                        new ImageIcon(getClass().getResource("/res/drawable/Pacman/pacman_down_3.png")).getImage()
                }
        };
        img = getImage();
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(img, x, y,SIZE,SIZE, null);
    }
    public void drawdie(Graphics2D graphics2D) {

        arrImg= new Image[][]{
                {
                        new ImageIcon(getClass().getResource("/res/drawable/Pacman/pacman_die_1.png")).getImage(),
                        new ImageIcon(getClass().getResource("/res/drawable/Pacman/pacman_die_2.png")).getImage(),
                        new ImageIcon(getClass().getResource("/res/drawable/Pacman/pacman_die_3.png")).getImage(),
                        new ImageIcon(getClass().getResource("/res/drawable/Pacman/pacman_die_4.png")).getImage(),

                }
        };
        orient=0;
        index=3;
        img = getImage();
        graphics2D.drawImage(img,x,y,SIZE,SIZE,null);
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

    public void move() {
        countMove++;
        img = getImage();
        if (x == Gui.WIDTH_FRAME-195){
            x=0;
        }
        if (x==-SIZE){
            x=Gui.WIDTH_FRAME-195;
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

    public boolean isDead() {
        return isDead;
    }
    public Rectangle getRectangle() {
        return rectangle;
    }

    public int getOrientation() {
        return orient;
    }

}
