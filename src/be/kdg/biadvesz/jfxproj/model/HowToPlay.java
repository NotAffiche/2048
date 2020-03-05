package be.kdg.biadvesz.jfxproj.model;

public class HowToPlay {
    //ATTRIB
    private String playerName;

    //GET & SET
    public String getPlayerName() { return playerName; }
    public void setPlayerName(String playerName) { this.playerName = playerName; }

    //CTOR
    public HowToPlay(String playerName) {
        setPlayerName(playerName);
    }
}
