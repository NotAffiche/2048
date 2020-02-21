package be.kdg.biadvesz.jfxproj.model;

public class Lobby {
    private String title;
    private String playername;

    public Lobby() {
        this.title = "2048 GAME";
        this.playername = playername;
    }

    public void startGame(Game game) {
        game.start();
    }
}
