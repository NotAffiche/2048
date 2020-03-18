package be.kdg.biadvesz.jfxproj.model;

import be.kdg.biadvesz.jfxproj.model.enums.Color;
import be.kdg.biadvesz.jfxproj.model.enums.Direction;
import be.kdg.biadvesz.jfxproj.model.enums.Gamestate;
import be.kdg.biadvesz.jfxproj.model.helpers.FileHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Game {
    //ATTRIB
    private int highscore;
    private int score;
    private Tile[][] grid;
    private int gridSize;
    private Random rndm;
    private String playername;
    private Gamestate state;
    private boolean hasWon;

    //GET & SET
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    public int getHighscore() { return this.highscore; }
    public void setHighscore(int highscore) { this.highscore = highscore; }
    public Tile[][] getGrid() { return grid; }
    public int getGridSize() { return this.gridSize; }
    public String getPlayername() { return this.playername; }
    public Gamestate getState() { return state; }
    public void setState(Gamestate state) { this.state = state; }

    //CTOR
    public Game(String playername, int gridSize) {
        this.playername = playername;
        this.gridSize = gridSize;
        this.grid = new Tile[getGridSize()][getGridSize()];
        hasWon=false;
        rndm = new Random();
        setScore(0);
        startGame();
    }

    //METHODS
    void startGame() {
        setState(Gamestate.ONGOING);
        //init game with 1st&2nd tile
        generateTile();
        generateTile();
    }

    public void endGame() {
        setState(Gamestate.FINISHED);
        FileHelper.saveScore(getPlayername(), getScore());
    }

    public void moveTiles(Direction d) {
        attemptGameEnd();
        boolean mergedOnceAlready = false;
        switch (d) {
            case UP:
                for (int row = 0; row < grid.length; row++) { // top to bottom
                    for (int col = 0; col < grid[row].length; col++) { // left to right
                        Tile t = grid[row][col];
                        while (canTileMove(t, d)) {
                            Tile other = grid[t.getPositionX() - 1][t.getPositionY()];
                            if (other == null) {
                                grid[t.getPositionX()][t.getPositionY()] = null;
                                t.setPositionX(t.getPositionX() - 1);
                                grid[t.getPositionX()][t.getPositionY()] = t;

                            } else {
                                if (!mergedOnceAlready) {
                                    other.valueChange(t);
                                    grid[t.getPositionX()][t.getPositionY()] = null;
                                    mergedOnceAlready = true;
                                    score += other.getValue();
                                } else {
                                    grid[t.getPositionX()][t.getPositionY()] = null;
                                    t.setPositionX(t.getPositionX() - 1);
                                    grid[t.getPositionX()][t.getPositionY()] = t;
                                }
                            }
                        }
                        mergedOnceAlready = false;
                    }
                }
                break;
            case RIGHT:
                for (int row = 0; row < grid.length; row++) { // top to bottom
                    for (int col = gridSize - 1; col >= 0; col--) { // right to left
                        Tile t = grid[row][col];
                        while (canTileMove(t, d)) {
                            Tile other = grid[t.getPositionX()][t.getPositionY() + 1];
                            if (other == null) {
                                grid[t.getPositionX()][t.getPositionY()] = null;
                                t.setPositionY(t.getPositionY() + 1);
                                grid[t.getPositionX()][t.getPositionY()] = t;
                            } else {
                                if (!mergedOnceAlready) {
                                    other.valueChange(t);
                                    grid[t.getPositionX()][t.getPositionY()] = null;
                                    mergedOnceAlready = true;
                                    score += other.getValue();
                                } else {
                                    grid[t.getPositionX()][t.getPositionY()] = null;
                                    t.setPositionY(t.getPositionY() + 1);
                                    grid[t.getPositionX()][t.getPositionY()] = t;
                                }
                            }
                        }
                        mergedOnceAlready = false;
                    }
                }
                break;
            case DOWN:
                for (int row = gridSize - 1; row >= 0; row--) { // bottom to top
                    for (int col = 0; col < grid[row].length; col++) { // left to right
                        Tile t = grid[row][col];
                        while (canTileMove(t, d)) {
                            Tile other = grid[t.getPositionX() + 1][t.getPositionY()];
                            if (other == null) {
                                grid[t.getPositionX()][t.getPositionY()] = null;
                                t.setPositionX(t.getPositionX() + 1);
                                grid[t.getPositionX()][t.getPositionY()] = t;
                            } else {
                                if (!mergedOnceAlready) {
                                    other.valueChange(t);
                                    grid[t.getPositionX()][t.getPositionY()] = null;
                                    mergedOnceAlready = true;
                                    score += other.getValue();
                                } else {
                                    grid[t.getPositionX()][t.getPositionY()] = null;
                                    t.setPositionX(t.getPositionX() + 1);
                                    grid[t.getPositionX()][t.getPositionY()] = t;
                                }
                            }
                        }
                        mergedOnceAlready = false;
                    }
                }
                break;
            case LEFT:
                for (int row = 0; row < grid.length; row++) { // top to bottom
                    for (int col = 0; col < grid[row].length; col++) { // left to right
                        Tile t = grid[row][col];
                        while (canTileMove(t, d)) {
                            Tile other = grid[t.getPositionX()][t.getPositionY() - 1];
                            if (other == null) {
                                grid[t.getPositionX()][t.getPositionY()] = null;
                                t.setPositionY(t.getPositionY() - 1);
                                grid[t.getPositionX()][t.getPositionY()] = t;
                            } else {
                                if (!mergedOnceAlready) {
                                    other.valueChange(t);
                                    grid[t.getPositionX()][t.getPositionY()] = null;
                                    mergedOnceAlready = true;
                                    score += other.getValue();
                                } else {
                                    grid[t.getPositionX()][t.getPositionY()] = null;
                                    t.setPositionY(t.getPositionY() - 1);
                                    grid[t.getPositionX()][t.getPositionY()] = t;
                                }
                            }
                        }
                        mergedOnceAlready = false;
                    }
                }
                break;
            default:
                System.out.println("Invalid input :/");
                break;
        }
        if (anyMovesLeft()) {
            generateTile();
        }
    }

    private boolean canTileMove(Tile t, Direction d) {
        int x;
        int y;
        switch (d) {
            case UP:
                if (t == null) break;
                x = t.getPositionX();
                y = t.getPositionY();
                if (x != 0) {
                    Tile other;
                    other = grid[x - 1][y];
                    return other == null || t.getValue() == other.getValue();
                }
                return false;
            case RIGHT:
                if (t == null) break;
                x = t.getPositionX();
                y = t.getPositionY();
                if (y != (gridSize - 1)) {
                    Tile other;
                    other = grid[x][y + 1];
                    return other == null || t.getValue() == other.getValue();
                }
                return false;
            case DOWN:
                if (t == null) break;
                x = t.getPositionX();
                y = t.getPositionY();
                if (x != (gridSize - 1)) {
                    Tile other;
                    other = grid[x + 1][y];
                    return other == null || t.getValue() == other.getValue();
                }
                return false;
            case LEFT:
                if (t == null) break;
                x = t.getPositionX();
                y = t.getPositionY();
                if (y != 0) {
                    Tile other;
                    other = grid[x][y - 1];
                    return other == null || t.getValue() == other.getValue();
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
                if (t != null) {
                    count++;
                }
            }
        }
        return (count == Math.pow(gridSize, 2));
    }

    private void generateTile() {
        int x = rndm.nextInt(gridSize);
        int y = rndm.nextInt(gridSize);

        while (tileExists(x, y)) {
            x = rndm.nextInt(gridSize);
            y = rndm.nextInt(gridSize);
        }
        int twoOrFour = rndm.nextInt(100);
        if (twoOrFour <= 90) {
            grid[x][y] = new Tile(2, x, y, Color.TWO);
        } else {
            grid[x][y] = new Tile(4, x, y, Color.FOUR);
        }
    }

    private boolean tileExists(int x, int y) {
        return grid[x][y] != null;
    }

    public void attemptGameEnd() {
        //won game
        if (found2048()&&!hasWon) {
            setState(Gamestate.FINISHED);
            hasWon=true;
            System.out.println("game over -> won");
        }
        //lost game
        if (isGridFull() && !anyMovesLeft()) {
            setState(Gamestate.FINISHED);
            System.out.println("game over -> lost");
        }
    }

    private boolean anyMovesLeft() {
        boolean movesLeft = false;
        for (Tile[] rows : grid) {
            for (Tile t : rows) {
                if (canTileMove(t, Direction.UP) || canTileMove(t, Direction.RIGHT) || canTileMove(t, Direction.DOWN) || canTileMove(t, Direction.LEFT)) {
                    movesLeft = true;
                }
            }
        }
        return movesLeft;
    }

    private boolean anyMovesLeft(Direction d) {
        boolean movesLeft = false;
        for (Tile[] rows : grid) {
            for (Tile t : rows) {
                if (canTileMove(t, d)) {
                    movesLeft = true;
                }
            }
        }
        return movesLeft;
    }

    public boolean found2048() {
        for (Tile[] row : grid) {
            for (Tile t : row) {
                if (t != null) {
                    if (t.getValue() == 2048) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //debug create tile
    public void createTile(int value) {
        int x = rndm.nextInt(gridSize);
        int y = rndm.nextInt(gridSize);

        while (tileExists(x, y)) {
            x = rndm.nextInt(gridSize);
            y = rndm.nextInt(gridSize);
        }
        grid[x][y] = new Tile(value, x, y, Color.MOST);
    }

    public boolean tryMove(Direction d) {
        if (anyMovesLeft(d)) {
            moveTiles(d);
            return true;
        }
        attemptGameEnd();
        return anyMovesLeft();
    }

    public void undo() {
        //TODO
    }
}
