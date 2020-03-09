package be.kdg.biadvesz.jfxproj.model;

public class WinGame {
    //ATTRIB
    private String playerName;

    //GET & SET
    public String getPlayerName() { return playerName; }
    public void setPlayerName(String playerName) { this.playerName = playerName; }

    //CTOR
    public WinGame(String playerName) {
        setPlayerName(playerName);
    }
}
