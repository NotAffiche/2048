package be.kdg.biadvesz.jfxproj.model;

import java.util.Random;

public class Game {
    private int highscore;
    private int score;
    private String title;
    private int[][] grid;
    private int gridSize;
    private Random rndm;

    public int getHighscore() { return highscore; }
    public void setHighscore(int highscore) { this.highscore = highscore; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int[][] getGrid() { return grid; }
    public void setGrid(int[][] grid) { this.grid = grid; }
    public int getGridSize() { return this.gridSize; }
    public void setGridSize(int gridSize) { this.gridSize = gridSize; }

    public Game() {
        rndm = new Random();
        setGrid(new int[getGridSize()][getGridSize()]); // gridsize (configurable in future?)
        setTitle("2048");
        setScore(0);
        //TODO: highscore
//        setHighscore();
    }

    public void start() {
        rndm.nextInt(getGridSize());
    }
}
