package ru.geekbrains.ticTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {
    private int panelWidth;
    private int panelHeight;
    private int cellHeight;
    private int cellWidth;

    private static final Random RANDOM = new Random();
    private static final int DOT_PADDING = 5;
    private int gameOverType;
    private boolean isGameOver;
    private boolean isInitialized;

    private static final int STATE_DRAW = 0;
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_AI = 2;

    private static final String MSG_DRAW = "Ничья!";
    private static final String MSG_WIN_HUMAN = "Победил игрок";
    private static final String MSG_WIN_AI = "Победил компьютер";
    private final int HUMAN_DOT = 1;
    private final int AI_DOT = 2;
    private final int EMPTY_DOT = 0;
    private int fieldSizeY = 3;
    private int fieldSizeX = 3;
    private char[][] field;

    public Map() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
        isInitialized = false;
    }

    private void update(MouseEvent e) {
        if(isGameOver || !isInitialized) return;
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) return;
        field[cellY][cellX] = HUMAN_DOT;

        if(checkEndGame(HUMAN_DOT, STATE_WIN_HUMAN)) return;
        aiTurn();
        repaint();
        if(checkEndGame(AI_DOT, STATE_WIN_AI)) return;
    }

    public void startNewGame(int mode, int fSzX, int fSzY, int wLen) {
        System.out.printf("Mode: %d;\nSize: x=%d, y=%d;\nWin Length: %d", mode, fSzX, fSzY, wLen);
//        протянуть установку длины поля
        initMap(fSzX, fSzY);
        isGameOver = false;
        isInitialized = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if(!isInitialized) return;
        panelWidth = getWidth();
        panelHeight = getHeight();
        cellHeight = panelHeight / SettingWindow.getFieldX();
        cellWidth = panelWidth / SettingWindow.getFieldY();

        g.setColor(Color.BLACK);
        for (int h = 0; h < SettingWindow.getFieldX(); h++) {
            int y = h * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }
        for (int w = 0; w < SettingWindow.getFieldY(); w++) {
            int x = w * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if(field[y][x] == EMPTY_DOT) continue;

                if(field[y][x] == HUMAN_DOT){
//                    ImageIcon icon = new ImageIcon( "src/main/resources/tac.jpg");
                    g.setColor(Color.BLUE);
                    g.fillOval(x * cellWidth + DOT_PADDING,
                               y * cellHeight + DOT_PADDING,
                               cellWidth - DOT_PADDING * 2,
                               cellHeight - DOT_PADDING * 2);

                } else if (field[y][x] == AI_DOT) {
                    g.setColor(Color.RED);
                    g.fillOval(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeight - DOT_PADDING * 2);

                } else {
                    throw new RuntimeException("Unexpected value " + field[y][x] +
                                                " in cell x=" + x +" y=" + y);
                }
            }

        }
        if(isGameOver) showMessageGameOver(g);

    }
    private void showMessageGameOver(Graphics g){
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 200, getWidth(), 70);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Times new roman", Font.BOLD, 28));
        switch (gameOverType){
            case STATE_DRAW: {
                g.drawString(MSG_DRAW, 180, getHeight()/2);
                break;
            }
            case STATE_WIN_AI:
                g.drawString(MSG_WIN_AI, 180, getHeight()/2); break;
            case  STATE_WIN_HUMAN:
                g.drawString(MSG_WIN_HUMAN, 180, getHeight()/2); break;
            default:
                throw new RuntimeException("Unexpected gameOver state" + gameOverType);
        }
    }

    private void initMap(int x, int y) {
        fieldSizeY = y;
        fieldSizeX = x;
        field = new char[fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    private boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private boolean isEmptyCell(int x, int y) {
        return field[y][x] == EMPTY_DOT;
    }

    private void aiTurn() {
        int x, y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = AI_DOT;
    }

    private boolean checkWin(char c) {
//        протянуть установку длинны поля
        int size = 3;
        for (int i = 0; i < size; i++)
            if ((field[i][0] == c && field[i][1] == c &&
                    field[i][2] == c) ||
                    (field[0][i] == c && field[1][i] == c &&
                            field[2][i] == c))
                return true;
        if ((field[0][0] == c && field[1][1] == c &&
                field[2][2] == c) ||
                (field[2][0] == c && field[1][1] == c &&
                        field[0][2] == c))
            return true;

//        if(checkDiagonal(c, size) || checkLanes(c, size)) return true;

        return false;
    }

    private boolean checkEndGame(int dot, int gameOverType){
        if(checkWin((char) dot)){
            this.gameOverType = gameOverType;
            isGameOver = true;
            repaint();
            return true;
        }
        if(isMapFull()){
            this.gameOverType = STATE_DRAW;
            isGameOver = true;
            repaint();
            return true;
        }
        return false;
    }

//    private boolean checkDiagonal(char c, int size) {
//        boolean toright, toleft;
//        toright = true;
//        toleft = true;
//        for (int i = 0; i < size; i++) {
//            toright &= (field[i][i] == c);
//            toleft &= (field[size - i - size][i] == c);
//        }
//        if (toright || toleft) return true;
//
//        return false;
//    }

//    private boolean checkLanes(char c, int size) {
//        boolean cols, rows;
//        for (int col = 0; col < size; col++) {
//            cols = true;
//            rows = true;
//            for (int row = 0; row < size; row++) {
//                cols &= (field[col][row] == c);
//                rows &= (
//                        field[row][col] == c);
//            }
//            if (cols || rows) return true;
//        }
//        return false;
//    }

    private boolean isMapFull() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }


}