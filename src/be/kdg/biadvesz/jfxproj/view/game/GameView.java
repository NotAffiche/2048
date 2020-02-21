package be.kdg.biadvesz.jfxproj.view.game;

import be.kdg.biadvesz.jfxproj.model.Game;
import be.kdg.biadvesz.jfxproj.model.Tile;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class GameView extends BorderPane {
    private Label lblTitle;
    private Label lblScore;
    private Label lblHighscore;


    public GameView() {
        initialise();
        layoutnodes();

    }
    private void initialise(){
        lblTitle = new Label("2048 Game");
        lblTitle.setStyle("-fx-font-size: 20px");
        lblScore = new Label();
        lblHighscore = new Label();

    }
    private  void layoutnodes(){
        super.setPadding(new Insets(10));
        super.getChildren().add(lblTitle);


    }

    public Label getLblTitle() {
        return lblTitle;
    }
    public Label getLblScore() {
        return lblScore;
    }
    public Label getLblHighscore() {
        return lblHighscore;
    }

    private void animateUp() {


    }

    private void animateDown() {


    }

    private void animateLeft() {


    }

    private void animateRight() {


    }
}
