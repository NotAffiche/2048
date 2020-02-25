package be.kdg.biadvesz.jfxproj.model;

public class Lobby {

    private String playerName;

    public String getPlayerName() {
        return playerName;
    }

    public Lobby() {

    }

    public void startGame(Game game) {
        game.startGame();
    }
}
