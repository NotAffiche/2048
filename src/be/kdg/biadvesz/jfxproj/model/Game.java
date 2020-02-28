package be.kdg.biadvesz.jfxproj.model;

import be.kdg.biadvesz.jfxproj.model.enums.Color;
import be.kdg.biadvesz.jfxproj.model.enums.Direction;
import be.kdg.biadvesz.jfxproj.model.helpers.FileHelper;

import java.util.Random;
import java.util.Scanner;

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

    //todo
    private Scanner scanner = new Scanner(System.in);

    public void startGame() {
//        rndm.nextInt(getGridSize());
        Tile t1 = new Tile(2, 1, 1, Color.TWO);
        Tile t2 = new Tile(2, 2, 2, Color.TWO);
        Tile t3 = new Tile(2, 3, 3, Color.TWO);
        grid[t1.getPositionX()][t1.getPositionY()] = t1;
        grid[t2.getPositionX()][t2.getPositionY()] = t2;
        grid[t3.getPositionX()][t3.getPositionY()] = t3;
        drawRoster();

        char input = scanner.next().charAt(0);
        while (input != 'q') {
            switch (input) {
                case 'w':
                    moveTiles(Direction.UP);
                    break;
                case 'a':
                    moveTiles(Direction.LEFT);
                    break;
                case 's':
                    moveTiles(Direction.DOWN);
                    break;
                case 'd':
                    moveTiles(Direction.RIGHT);
                    break;
                default:
                    System.out.println("Incorrect input :/");
                    break;
            }
            input = scanner.next().charAt(0);
            drawRoster();
        }
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
                            grid[t.getPositionX()][t.getPositionY()] = null;
                            t.setPositionX(t.getPositionX()-1);
                            grid[t.getPositionX()][t.getPositionY()] = t;
                        }
                        break;
                    case RIGHT:
                        while (canTileMove(t, d)) {
                            grid[t.getPositionX()][t.getPositionY()] = null;
                            t.setPositionY(t.getPositionY()+1);
                            grid[t.getPositionX()][t.getPositionY()] = t;
                        }
                        break;
                    case DOWN:
                        while (canTileMove(t, d)) {
                            grid[t.getPositionX()][t.getPositionY()] = null;
                            t.setPositionX(t.getPositionX()+1);
                            grid[t.getPositionX()][t.getPositionY()] = t;
                        }
                        break;
                    case LEFT:
                        while (canTileMove(t, d)) {
                            grid[t.getPositionX()][t.getPositionY()] = null;
                            t.setPositionY(t.getPositionY()-1);
                            grid[t.getPositionX()][t.getPositionY()] = t;
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
        int x;
        int y;
        switch (d) {
            case UP:
                if (t==null) break;
                x = t.getPositionX();
                y = t.getPositionY();
                if (x!=0) {
                    Tile other;
                    try {
                        if (x==0) return false;
                        other = grid[x-1][y];
                        if (other==null || t.getValue()==other.getValue()) {
                            return true;
                        }
                    } catch (Exception ex) {
                        throw ex;
                    }
                }
                return false;
            case RIGHT:
                if (t==null) break;
                x = t.getPositionX();
                y = t.getPositionY();
                if (x!=0) {
                    Tile other;
                    try {
                        if (y==3) return false;
                        other = grid[x][y+1];
                        if (other==null || t.getValue()==other.getValue()) {
                            return true;
                        }
                    } catch (Exception ex) {
                        throw ex;
                    }
                }
                return false;
            case DOWN:
                if (t==null) break;
                x = t.getPositionX();
                y = t.getPositionY();
                if (x!=0) {
                    Tile other;
                    try {
                        if (x==3) return false;
                        other = grid[x+1][y];
                        if (other==null || t.getValue()==other.getValue()) {
                            return true;
                        }
                    } catch (Exception ex) {
                        throw ex;
                    }
                }
                return false;
            case LEFT:
                if (t==null) break;
                x = t.getPositionX();
                y = t.getPositionY();
                if (x!=0) {
                    Tile other;
                    try {
                        if (y==0) return false;
                        other = grid[x][y-1];
                        if (other==null || t.getValue()==other.getValue()) {
                            return true;
                        }
                    } catch (Exception ex) {
                        throw ex;
                    }
                }
                return false;
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
                    System.out.printf("%d ", t.getValue());
                } catch (Exception ex) {
                    System.out.print("0 ");
                }
            }
            System.out.println(" ");
        }
    }
}
