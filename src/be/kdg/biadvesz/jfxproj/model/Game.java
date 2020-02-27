package be.kdg.biadvesz.jfxproj.model;

import be.kdg.biadvesz.jfxproj.model.enums.Color;
import be.kdg.biadvesz.jfxproj.model.enums.Direction;
import be.kdg.biadvesz.jfxproj.model.helpers.FileHelper;

import java.util.Random;

public class Game {
    private int highscore;
    private int score;
    private Tile[][] grid;
    private int gridSize;
    private Random rndm;
    private String playername;

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
        if (!FileHelper.dataExists()) {
            FileHelper.createHighscoreFile();
        }
        setGrid(new Tile[getGridSize()][getGridSize()]);
        setScore(0);
        setPlayername(playername);
        //TODO: highscore
        startGame();
    }

    public void startGame() {
//        rndm.nextInt(getGridSize());
        Tile t1 = new Tile(2, 1, 1, Color.TWO);
        Tile t2 = new Tile(2, 2, 2, Color.TWO);
        Tile t3 = new Tile(2, 3, 3, Color.TWO);
        grid[t1.getPositionX()][t1.getPositionY()] = t1;
        grid[t2.getPositionX()][t2.getPositionY()] = t2;
        grid[t3.getPositionX()][t3.getPositionY()] = t3;
    }

    public void endGame() {
        saveHighscore(getPlayername());
    }

    private void saveHighscore(String playername) {

    }

    public void moveTiles(Direction d) {
        for (Tile[] rows : grid) {
            for (Tile t : rows) {
                switch (d) {
                    case UP:
                        while (canTileMove(t, d)) {
                            t.setPositionX(t.getPositionX()-1);
                            drawRoster();
                        }
                        break;
                    case RIGHT:
                        while (canTileMove(t, d)) {
                            t.setPositionY(t.getPositionY()+1);
                            drawRoster();
                        }
                        break;
                    case DOWN:
                        while (canTileMove(t, d)) {
                            t.setPositionX(t.getPositionX()+1);
                            drawRoster();
                        }
                        break;
                    case LEFT:
                        while (canTileMove(t, d)) {
                            t.setPositionY(t.getPositionY()-1);
                            drawRoster();
                        }
                        break;
                    default:
                        System.out.println("Invalid input :/");
                        break;
                }
            }
        }
    }

    private boolean canTileMove(Tile t, Direction d) {
        switch (d) {
            case UP:
                int x = t.getPositionX();
                int y = t.getPositionY();
                if (x!=0) {
                    Tile other;
                    try {
                        other = grid[x-1][y];
                        if (t.getValue()==other.getValue()) {
                            return true;
                        }
                    } catch (Exception ex) {
                        throw ex;
                    }
                }
                return false;
            case RIGHT:
                break;
            case DOWN:
                break;
            case LEFT:
                break;
            default:
                System.out.println("Invalid input :/");
                break;
        }

        //TODO
        // check if adjacent tile has same value
        //TODO
        // check if adjacent spot is emtpy
        return false;
    }

    public void drawRoster() {
        for (Tile[] rows : grid) {
            for (Tile t : rows) {
                try {
                    System.out.printf("%f ", t.getValue());
                } catch (Exception ex) {
                    System.out.print("0 ");
                }
            }
            System.out.println(" ");
        }
    }
}
