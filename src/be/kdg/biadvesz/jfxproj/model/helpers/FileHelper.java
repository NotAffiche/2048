package be.kdg.biadvesz.jfxproj.model.helpers;

import java.io.File;
import java.io.IOException;

public class FileHelper {

    private final static String path = System.getProperty("user.home") + File.separator + "Documents/BiadVesz";

    public static boolean dataExists() {
        File highscore = new File(path);
        return highscore.exists();
    }

    public static void createHighscoreFile() {
        String path2 = path + "/2048";
        File folder = new File(path2);
        folder.mkdirs();
        File highscoreFile = new File(path2 + "/highscores.txt");
        try {
            highscoreFile.createNewFile();
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        }
    }
}
