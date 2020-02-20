package be.kdg.biadvesz.jfxproj.model;

import be.kdg.biadvesz.jfxproj.model.enums.Color;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private int highscore;
    private int score;
    private String title;
    private Tile[][] grid;
    private int gridSize;
    private Random rndm;

    public int getHighscore() { return highscore; }
    public void setHighscore(int highscore) { this.highscore = highscore; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Tile[][] getGrid() { return grid; }
    public void setGrid(Tile[][] grid) { this.grid = grid; }
    public int getGridSize() { return this.gridSize; }
    public void setGridSize(int gridSize) { this.gridSize = gridSize; }

    Scanner scanner = new Scanner(System.in);

    public Game() {
        rndm = new Random();
        setGridSize(4);
        setGrid(new Tile[getGridSize()][getGridSize()]); // gridsize (configurable in future?)
        setTitle("2048");
        setScore(0);



        start();
        String input = scanner.next();
        System.out.println(input);
        updateBoard();

        //TODO: highscore
//        setHighscore();
    }

    public void updateBoard() {
        for (int cols=0; cols<grid.length; cols++) {
            for (int rows=0;rows<cols;rows++) {
                if (grid[cols][rows]!=null) {
                    System.out.println("x");
                } else {
                    System.out.println("o");
                }
            }
        }
    }

    public void start() {
        int x = rndm.nextInt(getGridSize());
        int y = rndm.nextInt(getGridSize());
        grid[x][y] = new Tile(2, x, y, Color.TWO);
    }
}
