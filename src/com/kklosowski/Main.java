package com.kklosowski;

public class Main {

    public static void main(String[] args) {
        int animationSpeed = 1;
        CellBoard cellBoard = new CellBoard(100, 100, 10);
        DisplayWindow displayWindow = new DisplayWindow(cellBoard, animationSpeed);
        displayWindow.setVisible(true);
    }
}
