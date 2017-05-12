package com.tiny.game.view;

import com.tiny.game.manger.GameManager;
import com.tiny.game.model.Pacman;
import com.tiny.game.model.WavPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.BitSet;


public class GamePanel extends BaseContainer implements Runnable {

    public WavPlayer wavPlayer;
    private int score = 0;
    private JButton btnBack;
    private JLabel lbScore;
    private JLabel lbHeart;
    private GameManager gameManager;
    private BitSet bitSet;
    private boolean isGamePlaying;
    private OnBackGameButtonClickListener onBackGameButtonClickListener;

    public GamePanel() {
        super();
    }

    @Override
    public void initContainer() {
        setLayout(null);
        setBackground(Color.BLACK);
        setFocusable(true);
        wavPlayer = new WavPlayer("sound_111");
        wavPlayer.playSound();
        wavPlayer.loop(1000);
    }

    @Override
    public void initComponents() {
        Font font = new Font("Arial", Font.BOLD, 16);
        lbScore = new JLabel("Score:");
        lbScore.setFont(font);
        lbScore.setForeground(Color.CYAN);
        lbScore.setBounds(600, 30, 80, 20);
        add(lbScore);
        lbHeart = new JLabel("Heart:");
        lbHeart.setFont(font);
        lbHeart.setForeground(Color.RED);
        lbHeart.setBounds(600, 60, 80, 20);
        add(lbHeart);
        gameManager = new GameManager(1,score);
        bitSet = new BitSet(256);
        startGame();
        btnBack = new JButton("BACK ");
        btnBack.setBounds(600,Gui.HEIGHT_FRAME-100,100,30);
        add(btnBack);
    }

    @Override
    public void initListener() {
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onBackGameButtonClickListener.onBackGameButtonClicked();
            }
        });
        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                bitSet.set(e.getKeyCode(), true);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                bitSet.set(e.getKeyCode(), false);
            }
        };
        addKeyListener(keyAdapter);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        gameManager.drawItem(graphics2D);
        gameManager.drawMapBean1(graphics2D);
        gameManager.drawMapBean2(graphics2D);
        gameManager.drawGhost(graphics2D);
        gameManager.drawPacman(graphics2D);

        graphics2D.setColor(Color.WHITE);
        graphics2D.setFont(new Font("Arial", Font.BOLD, 18));
        graphics2D.drawString( " " + gameManager.getScore(), 660, 45);
        graphics2D.drawString( " " + gameManager.getHeart(), 660, 75);

        if (gameManager.getSupper()) {

            graphics2D.setFont(new Font("Arial", Font.BOLD, 16));
            graphics2D.drawString("SUPER PACMAN ", 600, 200);
        }

    }

    public void startGame() {
        Thread thread = new Thread(this);
        isGamePlaying = true;
        thread.start();
    }

    @Override
    public void run() {
        while (isGamePlaying) {
            if (bitSet.get(KeyEvent.VK_LEFT)) {
                gameManager.changePacmanOrentation(Pacman.LEFT);
            }
            if (bitSet.get(KeyEvent.VK_RIGHT)) {
                gameManager.changePacmanOrentation(Pacman.RIGHT);

            }
            if (bitSet.get(KeyEvent.VK_UP)) {
                gameManager.changePacmanOrentation(Pacman.UP);

            }
            if (bitSet.get(KeyEvent.VK_DOWN)) {
                gameManager.changePacmanOrentation(Pacman.DOWN);

            }
            gameManager.changeGhostOrientation();
            gameManager.bossAutoChangeOrient();
            gameManager.movePacman();
            gameManager.moveGhost();
            repaint();
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (gameManager.getMapBean1().size()<1){
                gameManager=new GameManager(gameManager.changLevel(),gameManager.getScore());
            }
            if (gameManager.getLevel()==4 ){
                wavPlayer.stopSound();
                WavPlayer winSound = new WavPlayer("win");
                winSound.playSound();
                int i = JOptionPane.showConfirmDialog(this, "Bạn đã thắng! \nĐiểm của bạn là: "+gameManager.getScore()+"\n Bạn có muốn chơi lại không?", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (i == JOptionPane.YES_OPTION) {

                    gameManager=new GameManager(1,0);
                    wavPlayer.playSound();
                    wavPlayer.loop(1000);
                }
                if (i== JOptionPane.NO_OPTION) {
                    onBackGameButtonClickListener.onBackGameButtonClicked();
                    gameManager =new GameManager(1,0);
                    wavPlayer.playSound();
                    wavPlayer.loop(1000);
                }
            }
            if (gameManager.isOver()) {
                WavPlayer wavPlayerDie = new WavPlayer("die");
                wavPlayerDie.playSound();
                wavPlayer.stopSound();
                int i = JOptionPane.showConfirmDialog(this, "Game Over !\nĐiểm của bạn là: " + gameManager.getScore() + "\n Bạn có muốn chơi lại không?", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (i == JOptionPane.YES_OPTION) {

                    gameManager=new GameManager(1,0);
                    wavPlayer.playSound();
                    wavPlayer.loop(1000);
                }
                if (i== JOptionPane.NO_OPTION) {
                    onBackGameButtonClickListener.onBackGameButtonClicked();
                    gameManager =new GameManager(1,0);
                    wavPlayer.playSound();
                    wavPlayer.loop(1000);
                }
            }
        }
    }
    public interface OnBackGameButtonClickListener {
        void onBackGameButtonClicked();

    }
    public void setOnBackGameButtonClickListener(GamePanel.OnBackGameButtonClickListener onBackGameButtonClickListener){
        this.onBackGameButtonClickListener = onBackGameButtonClickListener;
    }

}


