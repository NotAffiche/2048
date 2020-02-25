package be.kdg.biadvesz.jfxproj.model;

import java.util.Random;

public class Game {
    private int highscore;
    private int score;
    private Tile[][] grid;
    private int gridSize;
    private Random rndm;

    public int getHighscore() { return highscore; }
    public void setHighscore(int highscore) { this.highscore = highscore; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    public Tile[][] getGrid() { return grid; }
    public void setGrid(Tile[][] grid) { this.grid = grid; }
    public int getGridSize() { return this.gridSize; }
    public void setGridSize(int gridSize) { this.gridSize = gridSize; }

    public Game() {
        rndm = new Random();
        setGridSize(4);
        setGrid(new Tile[getGridSize()][getGridSize()]); // gridsize (configurable in future?)
        setScore(0);
        //TODO: highscore
//        setHighscore();
    }

    public void start() {
        rndm.nextInt(getGridSize());
    }
}
