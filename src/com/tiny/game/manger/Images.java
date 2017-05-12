package com.tiny.game.manger;


import javax.swing.*;
import java.awt.*;

public class Images {
    public static final Image IMG_WALL = new ImageIcon(Images.class.getResource("/res/drawable/wall.png")).getImage();
    public static final Image IMG_BEAN_1 = new ImageIcon(Images.class.getResource("/res/drawable/Item/bean_1.png")).getImage();
    public static final Image IMG_BEAN_2 = new ImageIcon(Images.class.getResource("/res/drawable/Item/bean_2.png")).getImage();
    public static final Image IMG_BEAN_3 = new ImageIcon(Images.class.getResource("/res/drawable/Item/bean_3.png")).getImage();
    public static final Image IMG_PACMAN_UP_1 = new ImageIcon(Images.class.getResource("/res/drawable/Pacman/pacman_top_1.png")).getImage();
    public static final Image IMG_PACMAN_UP_2 = new ImageIcon(Images.class.getResource("/res/drawable/Pacman/pacman_top_2.png")).getImage();
    public static final Image IMG_PACMAN_UP_3 = new ImageIcon(Images.class.getResource("/res/drawable/Pacman/pacman_top_3.png")).getImage();
    public static final Image IMG_PACMAN_DOWN_1 = new ImageIcon(Images.class.getResource("/res/drawable/Pacman/pacman_down_1.png")).getImage();
    public static final Image IMG_PACMAN_DOWN_2 = new ImageIcon(Images.class.getResource("/res/drawable/Pacman/pacman_down_2.png")).getImage();
    public static final Image IMG_PACMAN_DOWN_3 = new ImageIcon(Images.class.getResource("/res/drawable/Pacman/pacman_down_3.png")).getImage();
    public static final Image IMG_PACMAN_LEFT_1 = new ImageIcon(Images.class.getResource("/res/drawable/Pacman/pacman_left_1.png")).getImage();
    public static final Image IMG_PACMAN_LEFT_2 = new ImageIcon(Images.class.getResource("/res/drawable/Pacman/pacman_left_2.png")).getImage();
    public static final Image IMG_PACMAN_LEFT_3 = new ImageIcon(Images.class.getResource("/res/drawable/Pacman/pacman_left_3.png")).getImage();
    public static final Image IMG_PACMAN_RIGHT_1 = new ImageIcon(Images.class.getResource("/res/drawable/Pacman/pacman_right_1.png")).getImage();
    public static final Image IMG_PACMAN_RIGHT_2 = new ImageIcon(Images.class.getResource("/res/drawable/Pacman/pacman_right_2.png")).getImage();
    public static final Image IMG_PACMAN_RIGHT_3 = new ImageIcon(Images.class.getResource("/res/drawable/Pacman/pacman_right_3.png")).getImage();
    public static final Image IMG_PACMAN_0 = new ImageIcon(Images.class.getResource("/res/drawable/Pacman/pacman_0.png")).getImage();
    public static final Image IMG_GHOST_1 = new ImageIcon(Images.class.getResource("/res/drawable/Ghost/ghost_1.png")).getImage();
    public static final Image IMG_GHOST_2 = new ImageIcon(Images.class.getResource("/res/drawable/Ghost/ghost_2.png")).getImage();


    public static Image[][] arrImgBlinky = new Image[][]{
            {
                    new ImageIcon(Images.class.getResource("/res/drawable/Ghost/blinky_1.png")).getImage(),
                    new ImageIcon(Images.class.getResource("/res/drawable/Ghost/blinky_2.png")).getImage(),
            },
            {

                    new ImageIcon(Images.class.getResource("/res/drawable/Ghost/blinky_3.png")).getImage(),
                    new ImageIcon(Images.class.getResource("/res/drawable/Ghost/blinky_4.png")).getImage(),

            },
            {

                    new ImageIcon(Images.class.getResource("/res/drawable/Ghost/blinky_5.png")).getImage(),
                    new ImageIcon(Images.class.getResource("/res/drawable/Ghost/blinky_6.png")).getImage(),
            },
            {
                    new ImageIcon(Images.class.getResource("/res/drawable/Ghost/blinky_7.png")).getImage(),
                    new ImageIcon(Images.class.getResource("/res/drawable/Ghost/blinky_8.png")).getImage(),
            }
    };
    public static Image[][] arrImgClyde = new Image[][]{
            {
                    new ImageIcon(Images.class.getResource("/res/drawable/Ghost/clyde_1.png")).getImage(),
                    new ImageIcon(Images.class.getResource("/res/drawable/Ghost/clyde_2.png")).getImage(),
            },
            {
                    new ImageIcon(Images.class.getResource("/res/drawable/Ghost/clyde_3.png")).getImage(),
                    new ImageIcon(Images.class.getResource("/res/drawable/Ghost/clyde_4.png")).getImage(),

            },
            {
                    new ImageIcon(Images.class.getResource("/res/drawable/Ghost/clyde_5.png")).getImage(),
                    new ImageIcon(Images.class.getResource("/res/drawable/Ghost/clyde_6.png")).getImage(),
            },
            {
                    new ImageIcon(Images.class.getResource("/res/drawable/Ghost/clyde_7.png")).getImage(),
                    new ImageIcon(Images.class.getResource("/res/drawable/Ghost/clyde_8.png")).getImage(),
            }
    };
    public static Image[][] arrImgInky = new Image[][]{
            {
                    new ImageIcon(Images.class.getResource("/res/drawable/Ghost/inky_1.png")).getImage(),
                    new ImageIcon(Images.class.getResource("/res/drawable/Ghost/inky_2.png")).getImage(),
            },
            {
                    new ImageIcon(Images.class.getResource("/res/drawable/Ghost/inky_3.png")).getImage(),
                    new ImageIcon(Images.class.getResource("/res/drawable/Ghost/inky_4.png")).getImage(),

            },
            {
                    new ImageIcon(Images.class.getResource("/res/drawable/Ghost/inky_5.png")).getImage(),
                    new ImageIcon(Images.class.getResource("/res/drawable/Ghost/inky_6.png")).getImage(),
            },
            {
                    new ImageIcon(Images.class.getResource("/res/drawable/Ghost/inky_7.png")).getImage(),
                    new ImageIcon(Images.class.getResource("/res/drawable/Ghost/inky_8.png")).getImage(),
            }
    };
    public static Image IsGhost =  new ImageIcon(Images.class.getResource("/res/drawable/Ghost/ghost_1.png")).getImage();
}