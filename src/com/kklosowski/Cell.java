package com.kklosowski;

import java.awt.*;

/**
 * Created by kklosowski on 24/05/2017.
 */
public class Cell {

    private int x, y;
    private int size;
    private boolean state;
    private boolean nextState;

    public Cell(int x, int y) {
        this(x, y, 1, false);
    }

    public Cell(int x, int y, int size, boolean state) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.state = state;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isAlive() {
        return state;
    }

    public void calculateNextState(int numberOfNeighbours) {
        if (numberOfNeighbours < 2) nextState = false;
        else if (numberOfNeighbours == 3 && !state) nextState = true;
        else if (numberOfNeighbours > 3) nextState = false;
        else nextState = state;
    }

    public void draw(Graphics g) {
        if (state) {
            g.fillRect(x * size, y * size, size, size);
        }
    }

    public void tick() {
        state = nextState;
    }
}
