package be.kdg.biadvesz.jfxproj.model;

public class Score {
    //ATTRIB
    private String playername;
    private int score;
    private int gridsize;

    //GET&SET
    public String getPlayername() { return playername; }
    public int getScore() { return score; }
    public int getGridsize() { return gridsize; }

    //CTOR
    public Score(String playername, int score, int gridSize) {
        this.playername=playername;
        this.score=score;
        this.gridsize=gridSize;
    }

    @Override
    public String toString() {
        return "Score{" +
                "playername='" + playername + '\'' +
                ", score=" + score +
                ", gridsize=" + gridsize +
                '}';
    }
}
