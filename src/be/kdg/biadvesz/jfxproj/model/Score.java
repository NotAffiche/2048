package be.kdg.biadvesz.jfxproj.model;

public class Score {
    //ATTRIB
    private String playername;
    private int score;
    private int gridSize;

    //GET&SET
    public String getPlayername() { return playername; }
    public int getScore() { return score; }
    public int getGridSize() { return gridSize; }

    //CTOR
    public Score(String playername, int score, int gridSize) {
        this.playername=playername;
        this.score=score;
        this.gridSize=gridSize;
    }
}
