package be.kdg.biadvesz.jfxproj.model;

public class Lobby {

    private String playerName;

    public Lobby() {

    }

    public void startGame(Game game) {
        game.start();
    }
}
