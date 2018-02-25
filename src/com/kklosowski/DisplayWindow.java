package com.kklosowski;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kklosowski on 24/05/2017.
 */
public class DisplayWindow extends JFrame implements ActionListener {

    private static final String FRAME_TITLE = "Game Of Life";

    private final CellBoard cellBoard;
    private JPanel drawingPanel;
    private Timer animationTimer;
    private int animationSpeed;
    private int currentTime = 0;
    private int windowWidth;
    private int windowHeight;

    public DisplayWindow(CellBoard cellBoard, int animationSpeed) {
        super();
        this.cellBoard = cellBoard;
        this.animationSpeed = animationSpeed;
        this.windowWidth = cellBoard.getPixelWidth();
        this.windowHeight = cellBoard.getPixelHeight();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(FRAME_TITLE);
        this.setPreferredSize(new Dimension(windowWidth, windowHeight));
        this.setLocation(100, 100);

        cellBoard.initializeRandomly();

        animationTimer = new Timer(animationSpeed, this);

        drawingPanel = new JPanel() {
            public void paint(Graphics g) {
                super.paintComponent(g);
                cellBoard.draw(g);
            }
        };

        this.add(drawingPanel);
        this.pack();
        animationTimer.start();
    }


    public void start() {
        cellBoard.initializeRandomly();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        currentTime++;
        cellBoard.nextGeneration();
        drawingPanel.repaint();
    }
}
