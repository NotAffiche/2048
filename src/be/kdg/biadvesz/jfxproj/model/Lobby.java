package be.kdg.biadvesz.jfxproj.model;

import java.security.PrivateKey;

public class Lobby {
    private String title;
    private String playername;


    public Lobby(String playername) {
        this.title = "2048 GAME";
        this.playername = playername;
    }

}
