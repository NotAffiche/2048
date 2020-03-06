package be.kdg.biadvesz.jfxproj.view.game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;


public class GameView extends BorderPane {
    //ATTRIB
    private Label lblTitle;
    private Label lblScore;
    private Label lblHighscore;
    private Button btLeave;
    private int gridSize;

    //GET
    public Button getBtLeave() {
        return btLeave;
    }

    //CTOR
    public GameView(int gridSize) {
        this.gridSize = gridSize;
        initialise();
        layoutnodes();
    }

    //METHODS
    private void initialise() {
        lblTitle = new Label("2048 Game");
        lblScore = new Label(String.format("Score: \n %4s", "0"));
        lblHighscore = new Label(String.format("Highscore: \n %7s", "0"));
        btLeave = new Button("Leave");
    }

    private void layoutnodes() {
        super.setPadding(new Insets(12));
        HBox hBoxTop = new HBox();

        lblScore.setPadding(new Insets(0, 50, 0, 15));
        lblTitle.setPadding(new Insets(0, 20, 0, 0));

        lblTitle.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
        lblScore.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        lblHighscore.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));

        hBoxTop.getChildren().addAll(lblTitle, lblScore, lblHighscore);
        hBoxTop.setAlignment(Pos.CENTER);

        super.setTop(hBoxTop);
        HBox hboxmidden = new HBox();
        super.setCenter(hboxmidden);

        BorderPane bpButtonSave = new BorderPane();
        bpButtonSave.setRight(btLeave);
        btLeave.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 16));
        btLeave.setPadding(new Insets(12, 30, 12, 30));
        super.setBottom(bpButtonSave);


        GridPane gridPane = new GridPane();
        Button[][] btn = new Button[gridSize][gridSize];
        for (int i = 0; i < btn.length; i++) {
            for (int j = 0; j < btn.length; j++) {
                btn[i][j] = new Button("0");
                btn[i][j].setPrefSize(75, 75);
                gridPane.add(btn[i][j], i, j);
            }
        }

        hboxmidden.setPadding(new Insets(70, 10, 10, 10));
        hboxmidden.setAlignment(Pos.CENTER);
        hboxmidden.getChildren().addAll(gridPane);

        //background color
        super.setBackground(new Background(new BackgroundFill(Color.rgb(250, 248, 239), CornerRadii.EMPTY, Insets.EMPTY)));
    }


}
