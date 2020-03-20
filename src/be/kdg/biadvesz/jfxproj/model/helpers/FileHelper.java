package be.kdg.biadvesz.jfxproj.model.helpers;

import be.kdg.biadvesz.jfxproj.model.Game;
import be.kdg.biadvesz.jfxproj.model.Score;
import be.kdg.biadvesz.jfxproj.model.Tile;
import be.kdg.biadvesz.jfxproj.model.enums.Gamestate;
import javafx.scene.control.Alert;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class FileHelper {
    //ATTRIB
    private static final String base = System.getProperty("user.home");

    /*
    * Method used to save current game to a specified file (location determined by FileChooser in GamePresenter)
    * */
    public static void saveGame(File selectedFile, Game game) {
        try (Formatter output = new Formatter(selectedFile)){
            output.format("%s%n", game.getPlayername());
            output.format("%s%n", game.getState());
            output.format("%s%n", game.hasWon());
            output.format("%s%n", game.usedUndo());
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
        }
    }

    /*
    * Method used to load into current game from a specified file (location determined by FileChooser in GamePresenter)
    * */
    public static void loadGame(File selectedFile, Game game) {
        try {
            ArrayList<String> input = (ArrayList)Files.readAllLines(Paths.get(selectedFile.toURI()));
            String playerName = input.get(0);
            Gamestate gameState = Gamestate.valueOf(input.get(1));
            boolean hasWon = Boolean.getBoolean(input.get(2));
            boolean usedUndo = Boolean.getBoolean(input.get(3));
            int score = Integer.parseInt(input.get(4));
            int highScore = Integer.parseInt(input.get(5));
            int gridSize = Integer.parseInt(input.get(6));
            String[] grid1dString = input.get(7).split("\\s");
            Tile[][] grid = new Tile[gridSize][gridSize];
            if (game.getGridSize()==gridSize) {
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
                game.setUsedUndo(usedUndo);
                game.setScore(score);
                game.setHighscore(highScore);
                game.setGridSize(gridSize);
                game.setGrid(grid);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("File error");
                alert.setContentText("Wrong gridsize.\nGridsize in load file: " + gridSize + "\nGridsize in game: " + game.getGridSize());
                alert.showAndWait();
            }
        } catch (Exception e) {
        }
    }

    /*
    * Method to save highscores after a game has ended.
    * */
    public static void saveHighscore(String playername, int score, int gridSize) {
        try {
            File file = new File(base + "/highscores.2048hs");
            ArrayList<String> input = new ArrayList<>();
            if (file.length()!=0) {
                input = (ArrayList)Files.readAllLines(Paths.get(file.toURI()));
            }

            try (Formatter output = new Formatter(file)){
                for (String str : input) {
                    output.format("%s%n", str);
                }
                output.format("%s %s %s%n", playername, score, gridSize);
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("Error.");
            }
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Highscore error");
            alert.setContentText("Error with writing highscore file.");
        }
    }

    /*
    * Method to retrieve highscores from highscores file.
    * */
    public static List<Score> getHighscores() {
        File file = new File(base + "/highscores.2048hs");
        ArrayList<Score> highscores = new ArrayList<>();
        ArrayList<String> highscoresStrs = new ArrayList<>();
        if (file.length()!=0) {
            try {
                highscoresStrs = (ArrayList)Files.readAllLines(Paths.get(file.toURI()));
                for (String str : highscoresStrs) {
                    String[] scoreBase = str.split("\\s");
                    Score score = new Score(scoreBase[0], Integer.parseInt(scoreBase[1]), Integer.parseInt(scoreBase[2]));
                    highscores.add(score);
                }
            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Highscore error");
                alert.setContentText("Error with retrieving highscore file.");
            }
        }
        return highscores;
    }
}
