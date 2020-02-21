package be.kdg.biadvesz.jfxproj.view.lobby;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LobbyView extends BorderPane {
    //ATTRIB
    private Label lblName;
    private TextField tfName;
    private Button bHowTo;
    private Button bHighscores;
    private Button bPlay;

    //GET
    public Label getLblName() { return lblName; }
    public TextField getTfName() { return tfName; }
    public Button getbHowTo() { return bHowTo; }
    public Button getbHighscores() { return bHighscores; }
    public Button getbPlay() { return bPlay; }

    //SET
    public void setLblName(Label lblName) { this.lblName = lblName; }
    public void setTfName(TextField tfName) { this.tfName = tfName; }
    public void setbHowTo(Button bHowTo) { this.bHowTo = bHowTo; }
    public void setbHighscores(Button bHighscores) { this.bHighscores = bHighscores; }
    public void setbPlay(Button bPlay) { this.bPlay = bPlay; }

    //CTOR
    public LobbyView() {
        initNodes();
        layoutNodes();
    }

    //METHODS
    private void initNodes() {
        lblName = new Label("2048 Game");
        tfName = new TextField("Playername...");
        bHowTo = new Button("How To Play");
        bHighscores = new Button("Highscores");
        bPlay= new Button("Play");
    }
    private void layoutNodes() {
        HBox hboxTitle = new HBox();
        hboxTitle.getChildren().add(lblName);
        HBox hboxName = new HBox();
        hboxName.getChildren().add(tfName);
        HBox hboxHowTo = new HBox();
        hboxHowTo.getChildren().add(bHowTo);
        HBox hboxHighscores = new HBox();
        hboxHighscores.getChildren().add(bHighscores);
        HBox hboxPlay = new HBox();
        hboxPlay.getChildren().add(bPlay);
        VBox mainBox = new VBox();

        //actual layout


        //set all items
        super.setTop(hboxTitle);
        mainBox.getChildren().addAll(hboxName, hboxHowTo, hboxHighscores, hboxPlay);
        super.setCenter(mainBox);
    }
}
