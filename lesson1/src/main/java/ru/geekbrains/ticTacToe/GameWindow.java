package ru.geekbrains.ticTacToe;


import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GameWindow extends JFrame{
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 500;
    private static final int WINDOW_POSY = 100;
    private Map map;
    private SettingWindow settings;
    private JButton btnStart = new JButton("New Game");
    private JButton btnExit = new JButton("Exit");


    public GameWindow(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TicTacToe");

        try {
            setIconImage(ImageIO.read(new File("src/main/resources/logo.png")));
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        setResizable(false);


        settings = new SettingWindow(this);
        settings.setVisible(false);
        map = new Map();

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });

        JPanel panBotton = new JPanel(new GridLayout(1, 2));
        panBotton.add(btnStart);
        panBotton.add(btnExit);
        add(panBotton, BorderLayout.SOUTH);
        add(map);

        setVisible(true);
    }

    public void startNewGame(int mode, int fSzX, int fSzY, int wLen){
        map.startNewGame(mode, fSzX, fSzY, wLen);
    }
}
