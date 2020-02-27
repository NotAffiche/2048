package be.kdg.biadvesz.jfxproj.model;

public class Lobby {

    private String playerName;

    public void setPlayerName(String playerName) { this.playerName = playerName; }

    public String getPlayerName() {
        return playerName;
    }

    public Lobby() {

    }

    public void startGame(Game game) {
        game.startGame();
    }
}
