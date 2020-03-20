package be.kdg.biadvesz.jfxproj.model;

import be.kdg.biadvesz.jfxproj.model.enums.Direction;
import be.kdg.biadvesz.jfxproj.model.enums.Gamestate;
import be.kdg.biadvesz.jfxproj.model.helpers.FileHelper;

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
    private Tile[][] oldGrid;
    private boolean usedUndo;

    //GET & SET
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    public int getHighscore() { return this.highscore; }
    public void setHighscore(int highscore) { this.highscore = highscore; }
    public Tile[][] getGrid() { return grid; }
    public void setGrid(Tile[][] grid) { this.grid = grid; }
    public int getGridSize() { return this.gridSize; }
    public void setGridSize(int gridSize) { this.gridSize = gridSize; }
    public String getPlayername() { return this.playername; }
    public void setPlayername(String playername) { this.playername = playername; }
    public Gamestate getState() { return state; }
    public void setState(Gamestate state) { this.state = state; }
    public boolean hasWon() { return hasWon; }
    public void setHasWon(boolean hasWon) { this.hasWon = hasWon; }
    public boolean usedUndo() { return usedUndo; }
    public void setUsedUndo(boolean usedUndo) { this.usedUndo = usedUndo; }

    //CTOR
    public Game(String playername, int gridSize) {
        this.playername = playername;
        this.gridSize = gridSize;
        this.grid = new Tile[getGridSize()][getGridSize()];
        hasWon = false;
        usedUndo = false;
        this.score = 0;
        oldGrid = new Tile[getGridSize()][getGridSize()];
        rndm = new Random();
        startGame();
    }

    //METHODS
    //starts game
    private void startGame() {
        setState(Gamestate.ONGOING);
        //init game with 1st&2nd tile
        generateTile();
        generateTile();
    }
    //ends game
    private void endGame() {
        setState(Gamestate.FINISHED);
        if (!usedUndo) {
            FileHelper.saveHighscore(getPlayername(), getScore(), getGridSize());
        }
    }
    //move tiles in given direction (first saves old roster for undo functionality)
    public void moveTiles(Direction d) {
        attemptGameEnd();
        for (int row=0;row<grid.length;row++) {
            for (int col=0;col<grid[row].length;col++) {
                oldGrid[row][col] = grid[row][col];
            }
            System.out.println(" ");
        }
        System.out.println(" ");
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
    //checks if a specific tile can move in a specific direction
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
    //checks if the grid is full
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
    //generates a random tile
    private void generateTile() {
        int x = rndm.nextInt(gridSize);
        int y = rndm.nextInt(gridSize);

        while (tileExists(x, y)) {
            x = rndm.nextInt(gridSize);
            y = rndm.nextInt(gridSize);
        }
        int twoOrFour = rndm.nextInt(100);
        if (twoOrFour <= 90) {
            grid[x][y] = new Tile(2, x, y);
        } else {
            grid[x][y] = new Tile(4, x, y);
        }
    }
    //checks if tile exists in given location
    private boolean tileExists(int x, int y) {
        return grid[x][y] != null;
    }
    //attempts the game end
    public void attemptGameEnd() {
        //won game
        if (found2048()&&!hasWon) {
            setState(Gamestate.FINISHED);
            hasWon=true;
            endGame();
        }
        //lost game
        if (isGridFull() && !anyMovesLeft()) {
            setState(Gamestate.FINISHED);
            endGame();
        }
    }
    //checks if any moves are left in any direction
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
    //checks if moves are left in a specific direction
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
    //checks if 2048 has been found on the board
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
    //tries to move in a direction and also notifies if it is possible to move or not
    public boolean tryMove(Direction d) {
        if (anyMovesLeft(d)) {
            moveTiles(d);
            return true;
        }
        attemptGameEnd();
        return anyMovesLeft();
    }
    //goes back 1 move
    public void undo() {
        for (int row=0;row<grid.length;row++) {
            for (int col=0;col<grid[row].length;col++) {
                grid[row][col] = oldGrid[row][col];
            }
        }
        for (int row=0;row<grid.length;row++) {
            for (int col=0;col<grid[row].length;col++) {
                oldGrid[row][col] = grid[row][col];
            }
        }
        usedUndo=true;
    }
}
