package be.kdg.biadvesz.jfxproj.view.highscore;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HighscoreView extends Parent {
    //ATTRIB
    private Label lblTitel;
    private Label lbscore;
    private TextField tfscore;
    private Button bgoback;

    //GETTERS
    public Label getLblTitel() {
        return lblTitel;
    }

    public Label getLbscore() {
        return lbscore;
    }

    public TextField getTfscore() {
        return tfscore;
    }

    public Button getBgoback() {
        return bgoback;
    }

    //SETTERS
    public void setLblTitel(Label lblTitel) {
        this.lblTitel = lblTitel;
    }

    public void setLbscore(Label lbscore) {
        this.lbscore = lbscore;
    }

    public void setTfscore(TextField tfscore) {
        this.tfscore = tfscore;
    }


    public void setBgoback(Button bgoback) {
        this.bgoback = bgoback;
    }

    //CONSTRUCTOR


    public HighscoreView() {
        initNodes();
        layoutNodes();
    }

    private void initNodes() {
        lblTitel = new Label("highscores");
        lbscore = new Label("score: ");
        bgoback = new Button("back");
    }

    private void layoutNodes() {

    }


}
