package be.kdg.biadvesz.jfxproj.model;

public class LoseGame {
    //ATTRIB
    private String playerName;

    //GET & SET
    public String getPlayerName() { return playerName; }
    public void setPlayerName(String playerName) { this.playerName = playerName; }

    //CTOR
    public LoseGame(String playerName) {
        setPlayerName(playerName);
    }
}
