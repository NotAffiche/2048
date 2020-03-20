package be.kdg.biadvesz.jfxproj.model.helpers;

import be.kdg.biadvesz.jfxproj.model.Game;
import be.kdg.biadvesz.jfxproj.model.Highscore;
import be.kdg.biadvesz.jfxproj.model.Score;
import be.kdg.biadvesz.jfxproj.model.enums.Gamestate;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class FileHelper {

    private final static String highscoresFile = "/highscores.txt";

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

    public static Game loadGame(File selectedFile, Game game) {
        try {
            ArrayList<String> input = (ArrayList)Files.readAllLines(Paths.get(selectedFile.toURI()));
            String playerName = input.get(0);
            Gamestate gameState = Gamestate.valueOf(input.get(1));
            boolean hasWon = Boolean.getBoolean(input.get(2));
            int score = Integer.parseInt(input.get(3));
            int highScore = Integer.parseInt(input.get(4));
            int gridSize = Integer.parseInt(input.get(5));
            System.out.println(playerName);
            System.out.println(gameState);
            System.out.println(hasWon);
            System.out.println(score);
            System.out.println(highScore);
            System.out.println(gridSize);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static List<Score> getHighscores() {
        return new ArrayList<>();
    }
}
