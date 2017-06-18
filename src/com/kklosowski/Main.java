package com.kklosowski;

public class Main {

    public static void main(String[] args) {

        int animationSpeed = 100;
        CellBoard cellBoard = new CellBoard(100, 100, 15);
        DisplayWindow displayWindow = new DisplayWindow(cellBoard, animationSpeed);
        displayWindow.setVisible(true);
    }
}
