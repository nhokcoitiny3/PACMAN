package com.tiny.game.view;

import javax.swing.*;

/**
 * Created by Admin on 4/15/2017.
 */
public abstract class BaseContainer extends JPanel {
    public BaseContainer(){
        initContainer();
        initComponents();
        initListener();
    }
    public abstract void initContainer();
    public abstract void initComponents();
    public abstract void initListener();
}
