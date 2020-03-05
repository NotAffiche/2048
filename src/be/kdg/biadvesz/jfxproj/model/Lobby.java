package be.kdg.biadvesz.jfxproj.model;

public class Lobby {
    //ATTRIB
    private String playerName;

    //GET & SET
    public void setPlayerName(String playerName) { this.playerName = playerName; }
    public String getPlayerName() {
        return playerName;
    }

    //CTOR
    public Lobby() {

    }

    //METHOD
    public void startGame(Game game) {
        game.startGame();
    }
}
