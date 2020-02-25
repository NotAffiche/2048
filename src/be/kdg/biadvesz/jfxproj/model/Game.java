package be.kdg.biadvesz.jfxproj.model;

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

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Tile[][] getGrid() {
        return grid;
    }

    public void setGrid(Tile[][] grid) {
        this.grid = grid;
    }

    public int getGridSize() {
        return this.gridSize;
    }

    public void setGridSize(int gridSize) {
        this.gridSize = gridSize;
    }

    public String getPlayername() {
        return this.playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public Game(String playername) {
        rndm = new Random();
        setGridSize(4);
        setGrid(new Tile[getGridSize()][getGridSize()]);
        setScore(0);
        setPlayername(playername);
        //TODO: highscore
        getHighscore(getPlayername());
    }

    public void startGame() {
        if (existsHighscores()) {
            createHighscoreFile();
            System.out.println("writing file");
        }
        rndm.nextInt(getGridSize());
    }

    public void endGame() {
        saveHighscore(getPlayername());
    }

    private void getHighscore(String playername) {
//        this.highscore =
    }

    private void saveHighscore(String playername) {

    }

    private boolean existsHighscores() {
        File highscoreFile = new File("/Program Files/BiadVesz/2048/highscores.txt");
        return !highscoreFile.exists();
    }

    private void createHighscoreFile() {
        File highscoreFile = new File("/Program Files/BiadVesz/2048/highscores.txt");
        try {
            highscoreFile.createNewFile();
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        }
    }
}
