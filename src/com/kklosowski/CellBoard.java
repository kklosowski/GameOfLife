package com.kklosowski;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Eter on 24/05/2017.
 */
public class CellBoard {
    private int width, height;
    private int cellSize;
    private int generation = 0;
    private Cell[][] cells;

    public CellBoard(int width, int height, int cellSize) {
        this.width = width;
        this.height = height;
        this.cellSize = cellSize;
    }

    public void initializeRandomly(){

        cells = new Cell[width][height];
        Random rand = new Random();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                boolean state = rand.nextBoolean() && rand.nextBoolean() && rand.nextBoolean();
                cells[i][j] = new Cell(i, j, cellSize, state);
            }
        }
    }

    public int getPixelWidth(){
        return width * cellSize;
    }

    public int getPixelHeight() {
        return height * cellSize;
    }

    public void nextGeneration(){
        Arrays.stream(cells).flatMap(Arrays::stream)
                .forEach(c -> c.calculateNextState(countAliveNeighbours(c)));

        Arrays.stream(cells).flatMap(Arrays::stream)
                .forEach(Cell::tick);
    }

    private int countAliveNeighbours(Cell c){
        return (int)Arrays.stream(cells)
                .flatMap(Arrays::stream)
                .filter(x-> Math.abs(x.getX() - c.getX()) <= 1 && Math.abs(x.getY() - c.getY()) <= 1)
                .filter(Cell::isAlive)
                .filter(x -> !x.equals(c))
                .count();
    }

    public void draw(Graphics g){
        Arrays.stream(cells)
                .flatMap(Arrays::stream)
                .forEach(c -> c.draw(g));
    }

}
