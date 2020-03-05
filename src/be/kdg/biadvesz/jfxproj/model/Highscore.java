package be.kdg.biadvesz.jfxproj.model;

public class Highscore {
    //ATTRIB
    private String playerName;

    //GET & SET
    public String getPlayerName() { return playerName; }
    public void setPlayerName(String playerName) { this.playerName = playerName; }

    //CTOR
    public Highscore(String playerName) {
        setPlayerName(playerName);
    }
}
