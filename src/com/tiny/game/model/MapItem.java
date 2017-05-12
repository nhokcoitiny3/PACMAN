package com.tiny.game.model;

import com.tiny.game.manger.Images;

import java.awt.*;

/**
 * Created by Admin on 4/16/2017.
 */
public class
MapItem extends GameOject {

    private Rectangle rectangle;
    public static final int SIZE = 30;
    public static final int WALL = 5;
    public static final int BEAN1 = 1;
    public static final int BEAN2 = 2;
    private int type;

    public MapItem(int x, int y,int type) {
        super(x, y);
        this.type = type;
        rectangle = new Rectangle(x, y, SIZE,SIZE);
    }

    public void drawMap(Graphics2D graphics2D) {
        switch (type){
            case WALL:
            graphics2D.drawImage(Images.IMG_WALL,x,y,SIZE,SIZE,null);
            break;
            case MapItem.BEAN1:
                graphics2D.drawImage(Images.IMG_BEAN_1,x,y,SIZE,SIZE,null);
                break;
            case MapItem.BEAN2:
                graphics2D.drawImage(Images.IMG_BEAN_2,x,y,SIZE,SIZE,null);
                break;
        }
    }
    public Rectangle getRectangle() {
        return rectangle;
    }

}