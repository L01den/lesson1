package ru.geekbrains.ticTacToe;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class SettingWindow extends JFrame {

    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;
    private static int mode = 0;
    private static int fieldX = 3;
    private static int fieldY = 3;
    private static int winLen = 3;
    JButton btnStart = new JButton("Start new Game");

    public SettingWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        try {
            setIconImage(ImageIO.read(new File("src/main/resources/logo.png")));
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        setLayout(new GridLayout(10, 1));
        add(new JLabel("Mode"));

        ButtonGroup button = new ButtonGroup();
        JRadioButton pvp = new JRadioButton("Человек против человека");
        JRadioButton pve = new JRadioButton("Человек против компьютера");

        button.add(pvp);
        button.add(pve);
        add(pvp);
        add(pve);


        add(new JLabel("Выберите размер поля"));
        JLabel label = new JLabel("Текущий размер поля: 3");
        add(label);


        JSlider slider = new JSlider(3, 10, 3);

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {


                label.setText("Текущий размер поля: " + slider.getValue());
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pve.isSelected()){
                    mode = 1;
                }
                fieldX = slider.getValue();
                fieldY = slider.getValue();
                winLen = slider.getValue();

                gameWindow.startNewGame(mode, fieldX, fieldY, winLen);
                setVisible(false);
            }
        });
        add(slider);
        add(btnStart);
        setVisible(true);
    }


    public static int getFieldX() {
        return fieldX;
    }

    public static int getFieldY() {
        return fieldY;
    }
}

