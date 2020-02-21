package be.kdg.biadvesz.jfxproj.view.lobby;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class LobbyView extends BorderPane {
    //ATTRIB
    private Label lblName;
    private TextField tfName;
    private Button bHowTo;
    private Button bHighscores;
    private Button bPlay;

    //GET
    public Label getLblName() {
        return lblName;
    }
    public TextField getTfName() {
        return tfName;
    }
    public Button getbHowTo() {
        return bHowTo;
    }
    public Button getbHighscores() {
        return bHighscores;
    }
    public Button getbPlay() {
        return bPlay;
    }
    //SET
    public void setLblName(Label lblName) {
        this.lblName = lblName;
    }
    public void setTfName(TextField tfName) {
        this.tfName = tfName;
    }
    public void setbHowTo(Button bHowTo) {
        this.bHowTo = bHowTo;
    }
    public void setbHighscores(Button bHighscores) {
        this.bHighscores = bHighscores;
    }
    public void setbPlay(Button bPlay) {
        this.bPlay = bPlay;
    }

    //CTOR
    public LobbyView() {
        initNodes();
        layoutNodes();
    }

    //METHODS
    private void initNodes() {
        lblName = new Label();
        tfName = new TextField();
        bHowTo = new Button();
        bHighscores = new Button();
        bPlay= new Button();
    }
    private void layoutNodes() {
        HBox hboxLabel = new HBox();
        hboxLabel.getChildren().add(lblName);
        HBox hboxTextField = new HBox();
        hboxTextField.getChildren().add(tfName);
        HBox hboxHowTo = new HBox();
        hboxHowTo.getChildren().add(bHowTo);
        HBox hboxHighscores = new HBox();
        hboxHighscores.getChildren().add(bHighscores);
        HBox hboxPlay = new HBox();
        hboxPlay.getChildren().add(bPlay);
    }
}
