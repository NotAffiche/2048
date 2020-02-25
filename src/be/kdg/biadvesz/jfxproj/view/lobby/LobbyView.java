package be.kdg.biadvesz.jfxproj.view.lobby;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import static javafx.scene.paint.Color.CHOCOLATE;
import static javafx.scene.paint.Color.color;

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
        lblName = new Label("2048 Game");
        Tooltip madeBy = new Tooltip("Made by: Adrian Biedny & Szymon Vertenten");
        madeBy.setStyle("-fx-font-size: 20;");
        lblName.setTooltip(madeBy);
        tfName = new TextField();
        tfName.setTooltip(new Tooltip("Playername"));
        tfName.setPromptText("Playername...");

        bHowTo = new Button("How To Play");
        bHighscores = new Button("Highscores");
        bPlay = new Button("Play");

    }

    private void layoutNodes() {
        super.setPadding(new Insets(10));
        lblName.setStyle("-fx-font-size: 70px;");
        lblName.setPadding(new Insets(10));


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

        mainBox.setPadding(new Insets(10));


        //set all items
        hboxTitle.setAlignment(Pos.CENTER);
        hboxHowTo.setAlignment(Pos.CENTER);
        hboxName.setAlignment(Pos.CENTER);
        hboxPlay.setAlignment(Pos.CENTER);
        hboxHighscores.setAlignment(Pos.CENTER);
        super.setTop(hboxTitle);
        mainBox.getChildren().addAll(hboxName, hboxHowTo, hboxHighscores, hboxPlay);
        mainBox.setAlignment(Pos.CENTER);
        super.setCenter(mainBox);




        //styles
        //width
        bHowTo.setMinWidth(175);
        hboxHowTo.setPadding(new Insets(50, 0, 0, 0));
        bHighscores.setMinWidth(175);
        bPlay.setMinWidth(175);
        tfName.setMinWidth(175);
        //colors
        super.setBackground(new Background(new BackgroundFill(Color.rgb(250, 248, 239), CornerRadii.EMPTY, Insets.EMPTY)));

    }
}
