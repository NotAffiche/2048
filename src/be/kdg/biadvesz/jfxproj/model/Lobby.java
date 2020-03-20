package be.kdg.biadvesz.jfxproj.model;

public class Lobby {
    //ATTRIB
    private String playerName;

    //GET & SET
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) { this.playerName=playerName; }
    //CTOR
    public Lobby() {}
    public Lobby(String playerName) {
        this.playerName=playerName;
    }
}
