package be.kdg.biadvesz.jfxproj.model.helpers;

public class winGame {
    //ATTRIB
    private String playerName;

    //GET & SET
    public String getPlayerName() { return playerName; }
    public void setPlayerName(String playerName) { this.playerName = playerName; }

    //CTOR
    public winGame(String playerName) {
        setPlayerName(playerName);
    }
}
