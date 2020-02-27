package be.kdg.biadvesz.jfxproj.model;

import be.kdg.biadvesz.jfxproj.model.helpers.FileHelper;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Game {
    private int highscore;
    private int score;
    private Tile[][] grid;
    private int gridSize;
    private Random rndm;
    private String playername;
    private File highscoreFile;

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    public Tile[][] getGrid() { return grid; }
    public void setGrid(Tile[][] grid) { this.grid = grid; }
    public int getGridSize() { return this.gridSize; }
    public void setGridSize(int gridSize) { this.gridSize = gridSize; }
    public String getPlayername() { return this.playername; }
    public void setPlayername(String playername) { this.playername = playername; }

    public Game(String playername) {
        rndm = new Random();
        setGridSize(4);
        if (FileHelper.existsHighscores()) {
            FileHelper.createHighscoreFile();
        }
        setGrid(new Tile[getGridSize()][getGridSize()]);
        setScore(0);
        setPlayername(playername);
        //TODO: highscore
        startGame();
    }

    public void startGame() {
        rndm.nextInt(getGridSize());
    }

    public void endGame() {
        saveHighscore(getPlayername());
    }

    private void saveHighscore(String playername) {

    }

    private void moveTiles() {
        for (Tile[] t : grid) {
        }
    }
}
