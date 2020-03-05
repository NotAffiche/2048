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

    //CTOR
    public Game(String playername) {
        rndm = new Random();
        setGridSize(4);
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
    public void startGame() {
        setState(Gamestate.ONGOING);
        // temp debug tiles
//        Tile t0 = new Tile(2, 0, 0, Color.TWO);
//        Tile t1 = new Tile(2, 1, 0, Color.TWO);
//        Tile t2 = new Tile(2, 2, 0, Color.TWO);
//        Tile t3 = new Tile(2, 3, 0, Color.TWO);
//        grid[t0.getPositionX()][t0.getPositionY()] = t0;
//        grid[t1.getPositionX()][t1.getPositionY()] = t1;
//        grid[t2.getPositionX()][t2.getPositionY()] = t2;
//        grid[t3.getPositionX()][t3.getPositionY()] = t3;

//        Tile t5 = new Tile(2, 0, 1, Color.TWO);
//        grid[t5.getPositionX()][t5.getPositionY()] = t5;
//        Tile t6 = new Tile(2, 2, 1, Color.TWO);
//        grid[t6.getPositionX()][t6.getPositionY()] = t6;
//        Tile t7 = new Tile(2, 3, 1, Color.TWO);
//        grid[t7.getPositionX()][t7.getPositionY()] = t7;
        //init game with 1st tile
        generateTile();
        //draw roster
        drawRoster();

        // temp -> debugging inputs
        char input = scanner.next().charAt(0);
        while (input != 'q' && state==Gamestate.ONGOING) {
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
            drawRoster();
            System.out.println("grid full? " + isGridFull());
            if (state==Gamestate.FINISHED) System.out.println("Game over");
            input = scanner.next().charAt(0);
        }
    }

    public void endGame() {
        setState(Gamestate.FINISHED);
        saveHighscore();
    }

    private void saveHighscore() {
        FileHelper.saveScore(getPlayername(), getScore());
    }

    public void moveTiles(Direction d) {
//        for (Tile[] rows : grid) {
//            for (Tile t : rows) { } }
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
        if (grid[x][y]!=null) return true;
        return false;
    }

    // temp debug roster
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

    public void attemptGameEnd() {
//        if (isGridFull() && !areMovesPossible()) endGame();
        if (isGridFull()) endGame();
    }
}
