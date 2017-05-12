package com.tiny.game.view;


import com.tiny.game.manger.Images;
import com.tiny.game.model.WavPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuPanel extends BaseContainer {


    private static final Image PAC = new ImageIcon(MenuPanel.class.getResource("/res/drawable/pac_man.jpg")).getImage();
    private static final Image PAC_BG = new ImageIcon(MenuPanel.class.getResource("/res/drawable/bg.png")).getImage();
    private static final Image PAC_INTRO = new ImageIcon(MenuPanel.class.getResource("/res/drawable/pacman-intro.jpg")).getImage();

    private JButton btnPlay;
    private JButton btnOption;
    private JButton btnHelp;
    private JButton btnExit;
    private OnPlayGameButtonClickListener onPlayGameButtonClickListener;

    public MenuPanel() {
        super();
    }

    @Override
    public void initContainer() {
        setBackground(Color.BLACK);
        setLayout(null);
        setFocusable(true);
    }

    @Override
    public void initComponents() {
        btnPlay = new JButton("PLAY");
        btnPlay.setBackground(Color.LIGHT_GRAY);
        btnPlay.setForeground(Color.RED);
        btnPlay.setBounds(270, 150, 200, 30);
        add(btnPlay);

        btnHelp = new JButton("HELP");
        btnHelp.setBackground(Color.LIGHT_GRAY);
        btnHelp.setForeground(Color.RED);
        btnHelp.setBounds(270, 200, 200, 30);
        add(btnHelp);

        btnExit = new JButton("EXIT");
        btnExit.setBackground(Color.LIGHT_GRAY);
        btnExit.setForeground(Color.RED);
        btnExit.setBounds(270, 250, 200, 30);
        add(btnExit);

    }

    @Override
    public void initListener() {
        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onPlayGameButtonClickListener.onPlayGameButtonClicked();
            }
        });
        btnHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Người chơi điều khiển Pac-Man trong một mê cung và ăn các chấm pac (pac-dots).\n Nếu người chơi ăn hết các chấm pac thì Pac-Man được đưa qua màn chơi mới.\n Có 3 đối thủ là Blinky, Inky và Clyde đi rong tự do trong mê cung và cố gắng bắt Pac-Man.\n Nếu để bị bắt, Pac-Man sẽ bị mất mạng. \nGần 4 góc của mê cung có 4 chấm tròn to và phát sáng có tên là \n \"viên sức mạnh \", nếu Pac-Man ăn được các chấm này sẽ giúp Pac-Man có khả năng ăn các kẻ địch trong một thời gian ngắn.");
            }

        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = JOptionPane.showConfirmDialog(null,"Do you want to exit?","Exit",JOptionPane.YES_NO_OPTION);
                if (i==JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;

        graphics2D.drawImage(PAC_BG, 0, 0, Gui.WIDTH_FRAME, Gui.HEIGHT_FRAME, null);
        graphics2D.drawImage(PAC_INTRO, 220, 0, 300, 100, null);
        graphics2D.drawImage(PAC, 220, Gui.HEIGHT_FRAME - 300, 300, 300, null);
    }

    public interface OnPlayGameButtonClickListener {
        void onPlayGameButtonClicked();

    }

    public void setOnPlayGameButtonClickListener(OnPlayGameButtonClickListener onPlayGameButtonClickListener) {
        this.onPlayGameButtonClickListener = onPlayGameButtonClickListener;
    }

}
