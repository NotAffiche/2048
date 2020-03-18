package be.kdg.biadvesz.jfxproj.view.lobby;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private ComboBox gridSizes;

    //GET
    public Label getLblName() {
        return lblName;
    }
    public TextField getTfName() {
        return tfName;
    }
    public Button getbHowTo() { return bHowTo; }
    public Button getbHighscores() {
        return bHighscores;
    }
    public Button getbPlay() {
        return bPlay;
    }
    public ComboBox getGridSizes() { return gridSizes; }

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
        Tooltip madeBy = new Tooltip("Made by: Adrian Biedny & Szymon Vertenten");
        madeBy.setStyle("-fx-font-size: 20;");
        lblName.setTooltip(madeBy);
        tfName = new TextField();
        tfName.setTooltip(new Tooltip("Playername"));
        tfName.setPromptText("Playername...");
        bHowTo = new Button("How To Play");
        bHighscores = new Button("Highscores");
        bPlay = new Button("Play");
        bPlay.setDisable(true);
    }

    private void layoutNodes() {
        super.setPadding(new Insets(10));
        lblName.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 55));
        lblName.setPadding(new Insets(40,10,10,10));


        HBox hboxTitle = new HBox();
        hboxTitle.getChildren().add(lblName);
        HBox hboxName = new HBox();
        hboxName.getChildren().add(tfName);
        HBox hboxGridSize = new HBox();
        hboxName.getChildren().add(gridSizes);
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
        tfName.setMinWidth(175);
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
    }
}
