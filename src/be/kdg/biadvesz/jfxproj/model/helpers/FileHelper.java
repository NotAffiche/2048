package be.kdg.biadvesz.jfxproj.model.helpers;

import be.kdg.biadvesz.jfxproj.model.Game;
import be.kdg.biadvesz.jfxproj.model.Score;
import be.kdg.biadvesz.jfxproj.model.Tile;
import be.kdg.biadvesz.jfxproj.model.enums.Gamestate;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class FileHelper {

    public static void saveGame(File selectedFile, Game game) {
        try (Formatter output = new Formatter(selectedFile)){
            output.format("%s%n", game.getPlayername());
            output.format("%s%n", game.getState());
            output.format("%s%n", game.hasWon());
            output.format("%s%n", game.getScore());
            output.format("%s%n", game.getHighscore());
            output.format("%s%n", game.getGridSize());
            for (int row=0;row<game.getGrid().length;row++) {
                for (int col=0;col<game.getGrid()[row].length;col++) {
                    if (game.getGrid()[row][col]==null) {
                        output.format("%s ", 0);
                    } else {
                        output.format("%s ", game.getGrid()[row][col].toString());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void loadGame(File selectedFile, Game game) {
        try {
            ArrayList<String> input = (ArrayList)Files.readAllLines(Paths.get(selectedFile.toURI()));
            String playerName = input.get(0);
            Gamestate gameState = Gamestate.valueOf(input.get(1));
            boolean hasWon = Boolean.getBoolean(input.get(2));
            int score = Integer.parseInt(input.get(3));
            int highScore = Integer.parseInt(input.get(4));
            int gridSize = Integer.parseInt(input.get(5));
            String[] grid1dString = input.get(6).split("\\s");
            Tile[][] grid = new Tile[gridSize][gridSize];
            int i=0;
            for (int row=0;row<gridSize;row++) {
                for (int col=0;col<gridSize;col++) {
                    if (!grid1dString[i].equals("0")) {
                        grid[row][col]=new Tile(Integer.parseInt(grid1dString[i]), row, col);
                    }
                    i++;
                }
            }
            game.setPlayername(playerName);
            game.setState(gameState);
            game.setHasWon(hasWon);
            game.setScore(score);
            game.setHighscore(highScore);
            game.setGridSize(gridSize);
            game.setGrid(grid);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void saveHighscore(String playername, int score, int gridSize) {
//        File file = Paths.get("/highscores.2048hs");
//        try (Formatter output = new Formatter(file)){
//            output.format("%s%n", playername);
//            output.format("%s%n", score);
//            output.format("%s%n", gridSize);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }

    public static List<Score> getHighscores() {
        return new ArrayList<>();
    }
}
