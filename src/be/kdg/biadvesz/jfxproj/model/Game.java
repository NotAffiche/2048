package be.kdg.biadvesz.jfxproj.model;

import be.kdg.biadvesz.jfxproj.model.enums.Color;
import be.kdg.biadvesz.jfxproj.model.enums.Direction;
import be.kdg.biadvesz.jfxproj.model.enums.Gamestate;
import be.kdg.biadvesz.jfxproj.model.helpers.FileHelper;

import java.util.Random;
import java.util.Scanner;

public class Game {
    //ATTRIB
    private int highscore;
    private int score;
    private Tile[][] grid;
    private int gridSize;
    private Random rndm;
    private String playername;
    private Gamestate state;

    //GET & SET
    private int getScore() { return score; }
    private void setScore(int score) { this.score = score; }
    public int getHighscore() { return this.highscore; }
    public void setHighscore(int highscore) { this.highscore = highscore; }
    public Tile[][] getGrid() { return grid; }
    private void setGrid(Tile[][] grid) { this.grid = grid; }
    private int getGridSize() { return this.gridSize; }
    private void setGridSize(int gridSize) { this.gridSize = gridSize; }
    public String getPlayername() { return this.playername; }
    private void setPlayername(String playername) { this.playername = playername; }
    public Gamestate getState() { return state; }
    private void setState(Gamestate state) { this.state = state; }

    //CTOR
    public Game(String playername, int gridSize) {
        rndm = new Random();
        setGridSize(gridSize);
        if (!FileHelper.dataExists()) {
            FileHelper.createHighscoreFile();
        }
        setGrid(new Tile[getGridSize()][getGridSize()]);
        setScore(0);
        setPlayername(playername);
        startGame();
    }

    private Scanner scanner = new Scanner(System.in);

    //METHODS
    void startGame() {
        setState(Gamestate.ONGOING);
        //init game with 1st tile
        generateTile();
        generateTile();
    }

    public void endGame() {
        setState(Gamestate.FINISHED);
        saveHighscore();
    }

    private void saveHighscore() {
        FileHelper.saveScore(getPlayername(), getScore());
    }

    public void moveTiles(Direction d) {
        boolean mergedOnceAlready = false;
        switch (d) {
            case UP:
                for (int row=0;row<grid.length;row++) { // top to bottom
                    for (int col=0;col<grid[row].length;col++) { // left to right
                        Tile t = grid[row][col];
                        while (canTileMove(t, d)) {
                            try {
                                Tile other = grid[t.getPositionX()-1][t.getPositionY()];
                                if (other==null) {
                                    grid[t.getPositionX()][t.getPositionY()] = null;
                                    t.setPositionX(t.getPositionX()-1);
                                    grid[t.getPositionX()][t.getPositionY()] = t;
                                } else {
                                    if (!mergedOnceAlready) {
                                        other.valueChange(t);
                                        grid[t.getPositionX()][t.getPositionY()] = null;
                                        mergedOnceAlready = true;
                                    } else {
                                        grid[t.getPositionX()][t.getPositionY()] = null;
                                        t.setPositionX(t.getPositionX()-1);
                                        grid[t.getPositionX()][t.getPositionY()] = t;
                                    }
                                    break;
                                }
                            } catch (Exception ex) {
                                throw ex;
                            }
                        }
                        mergedOnceAlready=false;
                    }
                }
                break;
            case RIGHT:
                for (int row=0;row<grid.length;row++) { // top to bottom
                    for (int col=gridSize-1;col>=0;col--) { // right to left
                        Tile t = grid[row][col];
                        while (canTileMove(t, d)) {
                            try {
                                Tile other = grid[t.getPositionX()][t.getPositionY()+1];
                                if (other==null) {
                                    grid[t.getPositionX()][t.getPositionY()] = null;
                                    t.setPositionY(t.getPositionY()+1);
                                    grid[t.getPositionX()][t.getPositionY()] = t;
                                } else {
                                    if(!mergedOnceAlready) {
                                        other.valueChange(t);
                                        grid[t.getPositionX()][t.getPositionY()] = null;
                                        mergedOnceAlready=true;
                                    } else {
                                        grid[t.getPositionX()][t.getPositionY()] = null;
                                        t.setPositionY(t.getPositionY()+1);
                                        grid[t.getPositionX()][t.getPositionY()] = t;
                                    }
                                    break;
                                }
                            } catch (Exception ex) {
                                throw ex;
                            }
                        }
                        mergedOnceAlready=false;
                    }
                }
                break;
            case DOWN:
                for (int row=gridSize-1;row>=0;row--) { // bottom to top
                    for (int col=0;col<grid[row].length;col++) { // left to right
                        Tile t = grid[row][col];
                        while (canTileMove(t, d)) {
                            try {
                                Tile other = grid[t.getPositionX()+1][t.getPositionY()];
                                if (other==null) {
                                    grid[t.getPositionX()][t.getPositionY()] = null;
                                    t.setPositionX(t.getPositionX()+1);
                                    grid[t.getPositionX()][t.getPositionY()] = t;
                                } else {
                                    if(!mergedOnceAlready) {
                                        other.valueChange(t);
                                        grid[t.getPositionX()][t.getPositionY()] = null;
                                        mergedOnceAlready=true;
                                    } else {
                                        grid[t.getPositionX()][t.getPositionY()] = null;
                                        t.setPositionX(t.getPositionX()+1);
                                        grid[t.getPositionX()][t.getPositionY()] = t;
                                    }
                                    break;
                                }
                            } catch (Exception ex) {
                                throw ex;
                            }
                        }
                        mergedOnceAlready=false;
                    }
                }
                break;
            case LEFT:
                for (int row=0;row<grid.length;row++) { // top to bottom
                    for (int col=0;col<grid[row].length;col++) { // left to right
                        Tile t = grid[row][col];
                        while (canTileMove(t, d)) {
                            try {
                                Tile other = grid[t.getPositionX()][t.getPositionY()-1];
                                if (other==null) {
                                    grid[t.getPositionX()][t.getPositionY()] = null;
                                    t.setPositionY(t.getPositionY()-1);
                                    grid[t.getPositionX()][t.getPositionY()] = t;
                                } else {
                                    if(!mergedOnceAlready) {
                                        other.valueChange(t);
                                        grid[t.getPositionX()][t.getPositionY()] = null;
                                        mergedOnceAlready=true;
                                    } else {
                                        grid[t.getPositionX()][t.getPositionY()] = null;
                                        t.setPositionY(t.getPositionY()-1);
                                        grid[t.getPositionX()][t.getPositionY()] = t;
                                    }
                                    break;
                                }
                            } catch (Exception ex) {
                                throw ex;
                            }
                        }
                        mergedOnceAlready=false;
                    }
                }
                break;
            default:
                System.out.println("Invalid input :/");
                break;
        }
        generateTile();
        attemptGameEnd();
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
                if (y!=3) {
                    Tile other;
                    try {
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
                if (x!=3) {
                    Tile other;
                    try {
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
                if (y!=0) {
                    Tile other;
                    try {
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
        return false;
    }

    private boolean isGridFull() {
        int count = 0;
        for (Tile[] rows : grid) {
            for (Tile t : rows) {
                if (t!=null) {
                    count++;
                }
            }
        }
        return (count==Math.pow(gridSize,2));
    }

    private boolean areMovesPossible() {

        return false;
    }
    private void generateTile() {
        int x = rndm.nextInt(4);
        int y = rndm.nextInt(4);

        while (tileExists(x, y)) {
            x = rndm.nextInt(4);
            y = rndm.nextInt(4);
        }
        int twoOrFour = rndm.nextInt(100);
        if (twoOrFour<=75) {
            grid[x][y] = new Tile(2, x, y, Color.TWO);
        } else {
            grid[x][y] = new Tile(4, x, y, Color.FOUR);
        }
    }

    private boolean tileExists(int x, int y) {
        return grid[x][y] != null;
    }

    private void attemptGameEnd() {
//        if (isGridFull() && !areMovesPossible()) endGame();
        if (isGridFull()) endGame();
    }
}
