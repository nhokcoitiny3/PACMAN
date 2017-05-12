package com.tiny.game.view;

import com.tiny.game.model.WavPlayer;
import com.tiny.game.view.GamePanel.OnBackGameButtonClickListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Admin on 4/15/2017.
 */
public class Gui extends JFrame implements MenuPanel.OnPlayGameButtonClickListener,OnBackGameButtonClickListener{
    public static final int WIDTH_FRAME = 750;
    public static final int HEIGHT_FRAME = 660;
    private MenuPanel menuPanel;
    private GamePanel gamePanel;

    public Gui() {
        initGui();
        initComponent();
    }

    public void initGui() {
        setTitle("Game Demo");
        setLayout(new CardLayout());
        setSize(WIDTH_FRAME, HEIGHT_FRAME);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);




    }

    public void initComponent() {
        menuPanel = new MenuPanel();
        add(menuPanel);
        menuPanel.setOnPlayGameButtonClickListener(this);
        gamePanel = new GamePanel();
        gamePanel.setOnBackGameButtonClickListener(this);
    }

    @Override
    public void onPlayGameButtonClicked() {

        remove(menuPanel);
        if (gamePanel == null) {
            gamePanel = new GamePanel();
        }
        add(gamePanel);

        validate();
        gamePanel.requestFocusInWindow();
    }

    @Override
    public void onBackGameButtonClicked() {
        remove(gamePanel);
        if (menuPanel == null) {
            menuPanel = new MenuPanel();
        }
        add(menuPanel);
        validate();
        menuPanel.requestFocusInWindow();
    }
}
