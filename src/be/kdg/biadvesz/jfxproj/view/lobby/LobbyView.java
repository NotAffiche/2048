package be.kdg.biadvesz.jfxproj.view.lobby;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class LobbyView extends BorderPane {
    //ATTRIB
    private Label lblName;
    private TextField tfName;
    private Button bHowTo;
    private Button bHighscores;
    private Button bPlay;
    private Label lbgridSize;
    private ComboBox gridSizes;

    //GET
    TextField getTfName() {
        return tfName;
    }
    Button getbHowTo() { return bHowTo; }
    Button getbHighscores() {
        return bHighscores;
    }
    Button getbPlay() {
        return bPlay;
    }
    ComboBox getGridSizes() { return gridSizes; }

    //CTOR
    public LobbyView() {
        initNodes();
        layoutNodes();
    }

    //METHODS
    private void initNodes() {
        gridSizes = new ComboBox(FXCollections.observableArrayList(3, 4, 5, 6));
        gridSizes.getSelectionModel().select(1);
        lblName = new Label("2048 Game");
        lbgridSize = new Label("Chose your gridsize: ");
        Tooltip madeBy = new Tooltip("Made by: Adrian Biedny & Szymon Vertenten");
        madeBy.setStyle("-fx-font-size: 20;");
        lblName.setTooltip(madeBy);
        tfName = new TextField();
        tfName.setTooltip(new Tooltip("Playername"));
        tfName.setPromptText(String.format("%33s","Playername..."));
        bHowTo = new Button("How To Play");
        bHighscores = new Button("Highscores");
        bPlay = new Button("Play");
        bPlay.setDisable(true);
    }

    private void layoutNodes() {
        super.setPadding(new Insets(10));
        lblName.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 55));
        lblName.setPadding(new Insets(40,10,10,10));

        //Creating hboxes/vbox
        HBox hboxTitle = new HBox();
        HBox hboxName = new HBox();
        HBox hboxGridSize = new HBox(5);
        HBox hboxHowTo = new HBox();
        HBox hboxHighscores = new HBox();
        HBox hboxPlay = new HBox();
        VBox mainBox = new VBox();
        //inserting into hbox/vbox
        hboxTitle.getChildren().add(lblName);
        hboxName.getChildren().addAll(tfName);
        hboxGridSize.getChildren().addAll(lbgridSize,gridSizes);
        hboxHowTo.getChildren().add(bHowTo);
        hboxHighscores.getChildren().add(bHighscores);
        hboxPlay.getChildren().add(bPlay);
        mainBox.setPadding(new Insets(10));

        //set all items, positions
        hboxTitle.setAlignment(Pos.CENTER);
        hboxHowTo.setAlignment(Pos.CENTER);
        hboxName.setAlignment(Pos.CENTER);
        hboxGridSize.setAlignment(Pos.CENTER_LEFT);

        hboxPlay.setAlignment(Pos.CENTER);
        hboxHighscores.setAlignment(Pos.CENTER);
        super.setTop(hboxTitle);
        mainBox.getChildren().addAll(hboxName, hboxGridSize, hboxHowTo, hboxHighscores, hboxPlay);
        mainBox.setAlignment(Pos.CENTER);
        super.setCenter(mainBox);


        //styles
        bHowTo.setMinWidth(175);
        bHowTo.setPadding(new Insets(15));
        hboxHowTo.setPadding(new Insets(50, 0, 0, 0));
        bHighscores.setMinWidth(175);
        bHighscores.setPadding(new Insets(15));
        hboxHighscores.setPadding(new Insets(3));
        bPlay.setMinWidth(175);
        bPlay.setPadding(new Insets(15));
        tfName.setMinWidth(200);
        hboxGridSize.setPadding(new Insets(0,0,0,97.5));
        tfName.setPadding(new Insets(7, 0, 7, 0));


        //colors
        super.setBackground(new Background(new BackgroundFill(Color.rgb(250, 248, 239), CornerRadii.EMPTY, Insets.EMPTY)));
        bHighscores.setStyle("-fx-background-color: rgb(250, 211, 102)");
        bHowTo.setStyle("-fx-background-color: rgb(250, 211, 102)");
        bPlay.setStyle("-fx-background-color: rgb(250, 211, 102)");

        //fonts
        bPlay.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
        bHowTo.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
        bHighscores.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
        lbgridSize.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
    }
}
